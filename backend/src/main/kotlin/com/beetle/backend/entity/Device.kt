package com.beetle.backend.entity

import com.beetle.backend.client.request.TargetComponentRequest
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "devices")
data class Device(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "devices_sequence")
    @SequenceGenerator(name = "devices_sequence", sequenceName = "devices_sequence", allocationSize = 1)
    val id: Long? = null,

    val deviceId: String? = null,

    val status: String? = null,

    @Column(columnDefinition = "jsonb")
    val installedSoftware: List<TargetComponentRequest>? = null,

    val createdAt: LocalDateTime? = null,

    val updatedAt: LocalDateTime? = null,

    val updatedBy: String? = null
)