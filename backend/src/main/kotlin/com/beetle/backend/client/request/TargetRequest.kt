package com.beetle.backend.client.request

class TargetRequest {
    var metadata: TargetMetadataRequest? = null
    var spec: TargetSpecRequest? = null
}

class TargetMetadataRequest {
    var name: String? = null
    var labels: Map<String, String>? = null
}

class TargetSpecRequest {
    var displayName: String? = null
    var forceRedeploy: Boolean? = null
    var components: List<TargetComponentRequest>? = null
    var topologies: List<TopologyRequest>? = null
}

class TargetComponentRequest {
    var name: String? = null
    var type: String? = null
    var properties: Map<String, String>? = null
}

class TopologyRequest {
    var bindings: List<BindingRequest>? = null
}

class BindingRequest {
    var role: String? = null
    var provider: String? = null
    var config: Map<String, String>? = null
}