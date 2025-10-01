package com.beetle.backend.client

import com.beetle.backend.client.request.TargetRequest
import com.beetle.backend.client.request.UserRequest
import com.beetle.backend.client.response.TargetResponse
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.client.RestClient

@Component
class TargetClient(private val restClient: RestClient,
                   private val authClient: AuthClient,
                   @Value("\${application.orchestrator.auth.username}") private val username: String,
                   @Value("\${application.orchestrator.auth.password}") private val password: String) {

    fun createTarget(targetName: String, request: TargetRequest) {
        val userRequest = UserRequest().apply {
            this.username = this@TargetClient.username
            this.password = this@TargetClient.password
        }
        val userResponse = authClient.authenticate(userRequest)

        val response = restClient.post()
            .uri("/targets/registry/{targetName}", targetName)
            .header("Authorization", "Bearer ${userResponse!!.accessToken}")
            .body(request)
            .retrieve()
            .toBodilessEntity()

        println("Status: ${response.statusCode}")
        println("Headers: ${response.headers}")
    }

    fun getTarget(targetName: String): TargetResponse? {
        val userRequest = UserRequest().apply {
            this.username = this@TargetClient.username
            this.password = this@TargetClient.password
        }
        val userResponse = authClient.authenticate(userRequest)

        return restClient.get()
            .uri("/targets/registry/{targetName}", targetName)
            .header("Authorization", "Bearer ${userResponse!!.accessToken}")
            .retrieve()
            .body(TargetResponse::class.java)
    }
}