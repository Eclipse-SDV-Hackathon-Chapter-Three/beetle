package com.beetle.backend.client.response

class InstanceResponse {
    var metadata: InstanceResponseMetadata? = null
    var spec: InstanceResponseSpec? = null
    var status: InstanceResponseStatus? = null
}

class InstanceResponseMetadata {
    var namespace: String? = null
    var name: String? = null
    var etag: String? = null
    var labels: Map<String, String>? = null
}

class InstanceResponseSpec {
    var displayName: String? = null
    var solution: String? = null
    var target: TargetResponse? = null
}

class InstanceResponseStatus {
    var provisioningStatus: ProvisioningStatus? = null
    var lastModified: String? = null
    var deployed: Int? = null
    var targets: Int? = null
}