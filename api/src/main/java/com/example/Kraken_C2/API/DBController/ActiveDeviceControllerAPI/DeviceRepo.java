package com.example.Kraken_C2.API.DBController.ActiveDeviceControllerAPI;

import com.example.Kraken_C2.API.DBController.ActiveDeviceControllerAPI.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface DeviceRepo extends JpaRepository<com.example.Kraken_C2.API.DBController.ActiveDeviceControllerAPI.Device, Long> {

    @Query("SELECT d FROM Device d ORDER BY d.id ASC")
    List<com.example.Kraken_C2.API.DBController.ActiveDeviceControllerAPI.Device> findAllDevices();

    @Query("SELECT d FROM Device d WHERE d.online = TRUE")
    List<Device> findActiveDevices();

}
