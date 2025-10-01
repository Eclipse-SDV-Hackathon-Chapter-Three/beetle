package com.beetle.backend.service

import com.beetle.backend.client.TargetClient
import com.beetle.backend.client.request.TargetRequest
import com.beetle.backend.client.response.TargetResponse
import com.beetle.backend.mapper.TargetMapper
import org.springframework.stereotype.Service

@Service
class TargetService(private val targetClient: TargetClient, private val targetMapper: TargetMapper) {

    fun createTarget(targetName: String, request: TargetRequest) {
        targetClient.createTarget(targetName, request)
    }

    fun getTarget(targetName: String): TargetResponse? {
        return targetClient.getTarget(targetName)
    }

    fun deleteTarget(targetName: String) {
        targetClient.deleteTarget(targetName)
    }
}