package com.example.Kraken_C2.API.FileUpload;

import com.example.Kraken_C2.Config.DirectoryValues;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component // ✅ REQUIRED
@ConfigurationProperties(prefix = "storage") // ✅ use prefix
public class StorageProperties {

    @Setter
    private String location;

    private final DirectoryValues directoryValues;

    public StorageProperties(DirectoryValues directoryValues) {
        this.directoryValues = directoryValues;
    }

    public String getLocation() {
        return (location != null)
                ? location
                : directoryValues.getKrakenFileUploadPath();
    }
}