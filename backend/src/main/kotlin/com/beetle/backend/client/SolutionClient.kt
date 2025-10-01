package com.beetle.backend.client

import com.beetle.backend.client.request.SolutionContainerMetadataRequest
import com.beetle.backend.client.response.SolutionResponse
import com.beetle.backend.client.request.SolutionContainerRequest
import com.beetle.backend.client.request.SolutionRequest
import com.beetle.backend.client.request.UserRequest
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.client.RestClient

@Component
class SolutionClient(
    private val restClient: RestClient,
    private val authClient: AuthClient,
    @Value("\${application.orchestrator.auth.username:admin}") private val username: String,
    @Value("\${application.orchestrator.auth.password}") private val password: String
) {

    private fun createSolutionContainer(request: SolutionContainerRequest) {
        val userResponse = authClient.authenticate(UserRequest(username, password))

        val response = restClient
            .post()
            .uri("/solutioncontainers/${request.metadata.name}")
            .header("Authorization", "Bearer %s".format(userResponse!!.accessToken))
            .body(request)
            .retrieve()
    }

    fun createSolution(request: SolutionRequest) {
        val userResponse = authClient.authenticate(UserRequest(username, password))

        createSolutionContainer(SolutionContainerRequest(SolutionContainerMetadataRequest(request.spec!!.rootResource)))

        val response = restClient.post()
            .uri("/solutions/${request.spec!!.displayName}")
            .body(request)
            .header("Authorization", "Bearer %s".format(userResponse!!.accessToken))
            .retrieve()

        print(response)
    }
}