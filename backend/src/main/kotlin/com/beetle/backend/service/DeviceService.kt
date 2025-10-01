package com.beetle.backend.service

import com.beetle.backend.entity.Device
import com.beetle.backend.repository.DeviceRepository
import org.springframework.stereotype.Service

@Service
class DeviceService(private val deviceRepository: DeviceRepository) {

    fun searchDevices(): List<Device> {
        return deviceRepository.findAll()
    }

    fun findByDeviceId(deviceId: String): Device? {
        return deviceRepository.findByDeviceId(deviceId)
    }

    fun saveDevice(device: Device): Device {
        return deviceRepository.save(device)
    }

    fun deleteDevice(id: Long) {
        deviceRepository.deleteById(id)
    }
}