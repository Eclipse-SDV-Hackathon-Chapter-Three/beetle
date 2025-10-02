package com.beetle.backend.client.request

val sampleTargetRequest = TargetRequest(
    metadata = TargetMetadataRequest(
        topologies = listOf(
            TopologyRequest(
                bindings = listOf(
                    BindingRequest(
                        role = "ankaios",
                        provider = "providers.target.mqtt",
                        config = mapOf(
                            "name" to "proxy",
                            "brokerAddress" to "tcp://127.0.0.1:1883",
                            "clientID" to "symphony",
                            "requestTopic" to "coa-request",
                            "responseTopic" to "coa-response",
                            "timeoutSeconds" to "30"
                        )
                    )
                )
            )
        )
    )
)