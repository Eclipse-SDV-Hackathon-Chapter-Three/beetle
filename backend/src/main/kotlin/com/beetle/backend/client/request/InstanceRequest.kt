package com.beetle.backend.client.request

class InstanceRequest {
    var metadata: InstanceMetadataRequest? = null
    var spec: InstanceSpecRequest? = null
}

class InstanceMetadataRequest {
    var labels: Map<String, String>? = null
}

class InstanceSpecRequest {
    var displayName: String? = null
    var solution: String? = null
    var target: TargetRequest? = null
}