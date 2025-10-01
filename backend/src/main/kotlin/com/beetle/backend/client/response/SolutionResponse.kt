package com.beetle.backend.client.response

class SolutionResponse {
    var metadata: SolutionResponseMetadata? = null
    var spec: SolutionResponseSpec? = null
}

class SolutionResponseMetadata {
    var namespace: String? = null
    var name: String? = null
    var etag: String? = null
    var labels: Map<String, String>? = null
}

class SolutionResponseSpec {
    var displayName: String? = null
    var metadata: Map<String, String>? = null
    var components: List<ComponentResponse>? = null
    var rootResource: String? = null
}

class ComponentResponse {
    var name: String? = null
    var type: String? = null
    var properties: Map<String, String>? = null
}