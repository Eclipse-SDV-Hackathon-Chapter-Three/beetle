package com.beetle.backend.client

import com.beetle.backend.client.request.UserRequest
import com.beetle.backend.client.response.UserResponse
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import org.springframework.web.client.RestClient

@Component
class AuthClient(private val restClient: RestClient) {

    fun authenticate(request: UserRequest): UserResponse? {
        return restClient.post()
            .uri("/users/auth")
            .body(request)
            .retrieve()
            .body(UserResponse::class.java)
    }
}