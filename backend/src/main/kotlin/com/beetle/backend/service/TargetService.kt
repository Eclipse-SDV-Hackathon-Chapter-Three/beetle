package com.beetle.backend.service

import com.beetle.backend.client.TargetClient
import com.beetle.backend.client.request.*
import com.beetle.backend.client.response.TargetResponse
import com.beetle.backend.repository.DeviceRepository
import org.springframework.stereotype.Service

@Service
class TargetService(
    private val targetClient: TargetClient,
    private val deviceRepository: DeviceRepository
) {

    fun createTarget(targetName: String, componentRequest: TargetComponentRequest) {
        val device = deviceRepository.findByDeviceId(targetName)
        val installedSoftware = device?.installedSoftware ?: emptyList()
        
        val isDifferent = installedSoftware.none { installed ->
            installed.name == componentRequest.name &&
            installed.type == componentRequest.type &&
            installed.properties == componentRequest.properties
        }
        
        if (isDifferent) {
            val fullRequest = sampleTargetRequest.copy(
                spec = TargetSpecRequest(
                    components = listOf(componentRequest)
                )
            )
            targetClient.createTarget(targetName, fullRequest)
            
            val updatedDevice = device?.copy(
                installedSoftware = installedSoftware + componentRequest,
                country = "PT",
                prodMode = false
            )
            updatedDevice?.let { deviceRepository.save(it) }
        }
    }

    fun getTarget(targetName: String): TargetResponse? {
        return targetClient.getTarget(targetName)
    }

    fun deleteTarget(targetName: String) {
        targetClient.deleteTarget(targetName)
    }
}