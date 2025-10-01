package com.beetle.backend.controller

import com.beetle.backend.client.request.InstanceRequest
import com.beetle.backend.client.response.InstanceResponse
import com.beetle.backend.service.InstanceService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/instances")
class InstanceController(private val instanceService: InstanceService) {

    @PostMapping
    fun createInstance(@RequestBody request: InstanceRequest): InstanceResponse? {
        return instanceService.createInstance(request)
    }
}