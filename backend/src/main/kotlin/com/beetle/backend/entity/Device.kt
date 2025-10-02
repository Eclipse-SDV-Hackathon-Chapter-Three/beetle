package com.beetle.backend.entity

import com.beetle.backend.client.request.TargetComponentRequest
import jakarta.persistence.*
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes
import java.time.LocalDateTime

@Entity
@Table(name = "devices")
data class Device(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "devices_sequence")
    @SequenceGenerator(name = "devices_sequence", sequenceName = "devices_sequence", allocationSize = 1)
    val id: Long? = null,

    @Column(name = "device_id")
    val deviceId: String? = null,

    @Column(name = "installation_status")
    val status: String? = null,

    @JdbcTypeCode(SqlTypes.JSON)
    val installedSoftware: List<TargetComponentRequest>? = null,

    @Column(name = "created_at")
    val createdAt: LocalDateTime? = null,

    @Column(name = "updated_at")
    val updatedAt: LocalDateTime? = null,

    @Column(name = "updated_by")
    val updatedBy: String? = null,

    @Column(name = "prod_mode")
    var prodMode: Boolean = false,

    @Column(name = "country")
    var country: String? = null
)