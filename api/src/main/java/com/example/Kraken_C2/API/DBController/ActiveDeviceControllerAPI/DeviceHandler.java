package com.example.Kraken_C2.API.DBController.ActiveDeviceControllerAPI;

import com.example.Kraken_C2.API.DBController.ActiveDeviceControllerAPI.Device;
import com.example.Kraken_C2.API.DBController.ActiveDeviceControllerAPI.DeviceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DeviceHandler {

    @Autowired
    private DeviceRepo deviceRepo;

    @GetMapping("/findAllDevices")
    public List<com.example.Kraken_C2.API.DBController.ActiveDeviceControllerAPI.Device> getAllDevices() {
        return deviceRepo.findAllDevices();
    }

    @GetMapping("/findAllActiveDevices")
    public List<Device> getAllActiveDevices() {
        return deviceRepo.findActiveDevices();
    }

}
