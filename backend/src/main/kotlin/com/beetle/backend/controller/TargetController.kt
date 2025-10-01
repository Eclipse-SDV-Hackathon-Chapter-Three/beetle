package com.beetle.backend.controller

import com.beetle.backend.client.request.TargetRequest
import com.beetle.backend.client.response.TargetResponse
import com.beetle.backend.service.TargetService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/targets")
class TargetController(private val targetService: TargetService) {

    @PostMapping("/{targetName}")
    fun createTarget(@PathVariable targetName: String, @RequestBody request: TargetRequest) {
        targetService.createTarget(targetName, request)
    }

    @GetMapping("/{targetName}")
    fun getTarget(@PathVariable targetName: String): TargetResponse? {
        return targetService.getTarget(targetName)
    }

    @DeleteMapping("/{targetName}")
    fun deleteTarget(@PathVariable targetName: String) {
        targetService.deleteTarget(targetName)
    }
}