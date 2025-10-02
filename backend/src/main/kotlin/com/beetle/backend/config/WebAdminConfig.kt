package com.beetle.backend.config

import org.slf4j.LoggerFactory
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
        val logger = LoggerFactory.getLogger("RestClient")
        return RestClient.builder()
            .baseUrl("http://localhost:8082/v1alpha2")
            .requestInterceptor { request, body, execution ->
                logger.info("Request: {} {} - Body: {}", request.method, request.uri, String(body))
                val response = execution.execute(request, body)
                logger.info("Response: {} {} - Body: {}", response.statusCode, request.uri, response.body)
                response
            }
            .build()
    }
}
