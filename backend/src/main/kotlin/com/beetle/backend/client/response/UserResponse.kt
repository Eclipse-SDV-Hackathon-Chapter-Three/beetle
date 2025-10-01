package com.beetle.backend.client.response

class UserResponse {
    var accessToken: String? = null
    var tokenType: String? = null
    var username: String? = null
    var roles: List<String>? = null
}