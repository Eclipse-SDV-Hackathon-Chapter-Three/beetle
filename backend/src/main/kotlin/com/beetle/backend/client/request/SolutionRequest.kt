package com.beetle.backend.client.request

class SolutionRequest {
    var metadata: SolutionMetadataRequest? = null
    var spec: SolutionSpecRequest? = null
}

class SolutionMetadataRequest {
    var labels: Map<String, String>? = null
}

class SolutionSpecRequest {
    var displayName: String? = null
    var rootResource: String? = null
    var components: List<ComponentRequest>? = null
    var metadata: Map<String, String>? = null
}

class ComponentRequest {
    var name: String? = null
    var type: String? = null
    var properties: Map<String, String>? = null
}