package com.beetle.backend.mapper

import com.beetle.backend.client.request.*
import com.beetle.backend.entity.*
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.springframework.stereotype.Component

@Component
class TargetMapper(private val objectMapper: ObjectMapper) {

    fun toEntity(request: TargetRequest): TargetEntity {
        val entity = TargetEntity().apply {
            name = request.metadata?.name
            displayName = request.spec?.displayName
            forceRedeploy = request.spec?.forceRedeploy
            labels = request.metadata?.labels?.let { objectMapper.writeValueAsString(it) }
        }

        request.spec?.components?.forEach { component ->
            val componentEntity = TargetComponentEntity().apply {
                name = component.name
                type = component.type
                properties = component.properties?.let { objectMapper.writeValueAsString(it) }
                target = entity
            }
            entity.components.add(componentEntity)
        }

        request.spec?.topologies?.forEach { topology ->
            val topologyEntity = TopologyEntity().apply {
                target = entity
            }
            topology.bindings?.forEach { binding ->
                val bindingEntity = BindingEntity().apply {
                    role = binding.role
                    provider = binding.provider
                    config = binding.config?.let { objectMapper.writeValueAsString(it) }
                    this.topology = topologyEntity
                }
                topologyEntity.bindings.add(bindingEntity)
            }
            entity.topologies.add(topologyEntity)
        }

        return entity
    }

    fun toRequest(entity: TargetEntity): TargetRequest {
        return TargetRequest().apply {
            metadata = TargetMetadataRequest().apply {
                name = entity.name
                labels = entity.labels?.let { jsonString -> objectMapper.readValue<Map<String, String>>(jsonString) }
            }
            spec = TargetSpecRequest().apply {
                displayName = entity.displayName
                forceRedeploy = entity.forceRedeploy
                components = entity.components.map { component ->
                    TargetComponentRequest().apply {
                        name = component.name
                        type = component.type
                        properties = component.properties?.let { jsonString -> objectMapper.readValue<Map<String, String>>(jsonString) }
                    }
                }
                topologies = entity.topologies.map { topology ->
                    TopologyRequest().apply {
                        bindings = topology.bindings.map { binding ->
                            BindingRequest().apply {
                                role = binding.role
                                provider = binding.provider
                                config = binding.config?.let { jsonString -> objectMapper.readValue<Map<String, String>>(jsonString) }
                            }
                        }
                    }
                }
            }
        }
    }
}