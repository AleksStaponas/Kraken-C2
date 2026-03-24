package com.example.Kraken_C2.API.DBController.ActiveDeviceControllerAPI;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface DeviceRepo extends JpaRepository<Device, Long> {

    @Query("SELECT d FROM Device d ORDER BY d.id ASC")
    List<Device> findAllDevices();

    @Query("SELECT d FROM Device d WHERE d.online = TRUE")
    List<Device> findActiveDevices();

}
