package com.beetle.backend.repository

import com.beetle.backend.entity.Device
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DeviceRepository : JpaRepository<Device, Long> {
    fun findByDeviceId(deviceId: String): Device?
    fun findByDeviceIdContainingIgnoreCase(deviceId: String): List<Device>
}