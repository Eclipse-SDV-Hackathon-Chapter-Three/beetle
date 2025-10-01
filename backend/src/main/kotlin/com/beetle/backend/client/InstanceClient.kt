package com.beetle.backend.client

import com.beetle.backend.client.response.InstanceResponse
import com.beetle.backend.client.request.InstanceRequest
import com.beetle.backend.client.request.UserRequest
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.client.RestClient

@Component
class InstanceClient(
    private val restClient: RestClient,
    private val authClient: AuthClient,
    @Value("\${application.orchestrator.auth.username}") private val username: String,
    @Value("\${application.orchestrator.auth.password}") private val password: String) {

    fun createInstance(request: InstanceRequest): InstanceResponse? {
        val userRequest = UserRequest().apply {
            this.username = this@InstanceClient.username
            this.password = this@InstanceClient.password
        }
        val userResponse = authClient.authenticate(userRequest)

        return restClient.post()
            .uri("/instances")
            .body(request)
            .retrieve()
            .body(InstanceResponse::class.java)
    }
}