package com.beetle.backend.controller

import com.beetle.backend.entity.Device
import com.beetle.backend.service.DeviceService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/vehicles")
class VehicleApiController(private val deviceService: DeviceService) {

    @GetMapping("/devices/search")
    fun searchDevices(): List<Device> {
        return deviceService.searchDevices()
    }

    @GetMapping("/devices/{deviceId}")
    fun getDevice(@PathVariable deviceId: String): Device? {
        return deviceService.findByDeviceId(deviceId)
    }

    @PostMapping("/devices")
    fun createDevice(@RequestBody device: Device): Device {
        return deviceService.saveDevice(device)
    }

    @DeleteMapping("/devices/{id}")
    fun deleteDevice(@PathVariable id: Long) {
        deviceService.deleteDevice(id)
    }
}