package com.beetle.backend.client

import com.beetle.backend.client.request.SolutionContainerMetadataRequest
import com.beetle.backend.client.response.SolutionResponse
import com.beetle.backend.client.request.SolutionContainerRequest
import com.beetle.backend.client.request.SolutionRequest
import com.beetle.backend.client.request.UserRequest
import com.beetle.backend.client.response.UserResponse
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

    private fun createSolutionContainer(userResponse: UserResponse?, solutionContainerRequest: SolutionContainerRequest) {
        val response = restClient
            .post()
            .uri("/solutioncontainers/${solutionContainerRequest.metadata.name}")
            .header("Authorization", "Bearer %s".format(userResponse!!.accessToken))
            .body(solutionContainerRequest)
            .retrieve()

        print(response)
    }

    fun createSolution(request: SolutionRequest) {
        val userResponse = authClient.authenticate(UserRequest(username, password))

        val solutionContainerRequest = SolutionContainerRequest(SolutionContainerMetadataRequest(request.spec!!.rootResource))

        createSolutionContainer(userResponse, solutionContainerRequest)

        val response = restClient.post()
            .uri("/solutions/${request.spec!!.displayName}")
            .body(request)
            .header("Authorization", "Bearer %s".format(userResponse!!.accessToken))
            .retrieve()

        print(response)
    }

    fun getSolution(solutionName: String): SolutionResponse? {
        val userRequest = UserRequest().apply {
            this.username = this@SolutionClient.username
            this.password = this@SolutionClient.password
        }
        val userResponse = authClient.authenticate(userRequest)

        return restClient.get()
            .uri("/solutions/{solutionName}", solutionName)
            .header("Authorization", "Bearer ${userResponse!!.accessToken}")
            .retrieve()
            .body(SolutionResponse::class.java)
    }
}