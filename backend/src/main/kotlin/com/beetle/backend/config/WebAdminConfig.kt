package com.beetle.backend.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestClient
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebAdminConfig(
) : WebMvcConfigurer {

    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/v1/vehicles/**").allowedMethods("DELETE", "GET", "HEAD", "OPTIONS", "PATCH", "POST", "PUT")
        registry.addMapping("/**").allowedMethods("DELETE", "GET", "HEAD", "OPTIONS", "PATCH", "POST", "PUT")
    }

    @Bean
    fun restClient(): RestClient {
        return RestClient.builder()
            .baseUrl("http://localhost:8082/v1alpha2")
            .build()
    }
}
