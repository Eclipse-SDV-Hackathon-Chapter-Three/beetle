package com.beetle.backend.client.request

data class TargetRequest(
    val metadata: TargetMetadataRequest? = null,
    val spec: TargetSpecRequest? = null
)

data class TargetMetadataRequest(
    val name: String? = null,
    val labels: Map<String, String>? = null,
    val topologies: List<TopologyRequest>? = null
)

data class TargetSpecRequest(
    val displayName: String? = null,
    val forceRedeploy: Boolean? = null,
    val components: List<TargetComponentRequest>? = null,
    val topologies: List<TopologyRequest>? = null
)

data class TargetComponentRequest(
    val name: String? = null,
    val type: String? = null,
    val properties: Map<String, String>? = null
)

data class TopologyRequest(
    val bindings: List<BindingRequest>? = null
)

data class BindingRequest(
    val role: String? = null,
    val provider: String? = null,
    val config: Map<String, String>? = null
)