package com.beetle.backend.service

import com.beetle.backend.client.TargetClient
import com.beetle.backend.client.request.TargetRequest
import com.beetle.backend.client.response.TargetResponse
import com.beetle.backend.mapper.TargetMapper
import com.beetle.backend.repository.TargetRepository
import org.springframework.stereotype.Service

@Service
class TargetService(
    private val targetClient: TargetClient, private val targetMapper: TargetMapper,
    private val targetRepository: TargetRepository
) {

    fun createTarget(targetName: String, request: TargetRequest) {
        targetClient.createTarget(targetName, request)
        val target = targetMapper.toEntity(request)
        targetRepository.save(target)
    }

    fun getTarget(targetName: String): TargetResponse? {
        return targetClient.getTarget(targetName)
    }

    fun deleteTarget(targetName: String) {
        targetClient.deleteTarget(targetName)
    }
}