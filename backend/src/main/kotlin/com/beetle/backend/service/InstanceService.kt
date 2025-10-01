package com.beetle.backend.service

import com.beetle.backend.client.InstanceClient
import com.beetle.backend.client.request.InstanceRequest
import com.beetle.backend.client.response.InstanceResponse
import org.springframework.stereotype.Service

@Service
class InstanceService(private val instanceClient: InstanceClient) {

    fun createInstance(request: InstanceRequest): InstanceResponse? {
        return instanceClient.createInstance(request)
    }
}