package com.beetle.backend.client.response

class TargetResponse {
    var metadata: TargetResponseMetadata? = null
    var status: TargetResponseStatus? = null
    var spec: TargetResponseSpec? = null
}

class TargetResponseMetadata {
    var namespace: String? = null
    var name: String? = null
    var etag: String? = null
    var labels: Map<String, String>? = null
}

class TargetResponseStatus {
    var provisioningStatus: ProvisioningStatus? = null
    var lastModified: String? = null
    var deployed: Int? = null
    var targets: Int? = null
}

class ProvisioningStatus {
    var operationId: String? = null
    var status: String? = null
    var error: Map<String, Any>? = null
}

class TargetResponseSpec {
    var displayName: String? = null
    var topologies: List<TopologyResponse>? = null
}

class TopologyResponse {
    var bindings: List<BindingResponse>? = null
}

class BindingResponse {
    var role: String? = null
    var provider: String? = null
    var config: Map<String, String>? = null
}