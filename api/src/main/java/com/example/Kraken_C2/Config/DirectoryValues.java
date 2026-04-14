package com.example.Kraken_C2.Config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DirectoryValues {

    @Value("${app.kraken.terminal.path}")
    private String krakenTerminalPath;

    @Getter
    @Value("${app.kraken.file-upload.upload-dir}")
    private String krakenFileUploadPath;

    @Getter
    @Value("${app.kraken.file-upload.log-file}")
    private String krakenLogFile;

    @Getter
    @Value("${logging.GOContact}")
    public String krakenGOContactLogFile;

    public String getKrakenPath() {
        return krakenTerminalPath;
    }

    public String krakenGOContactLogFile() {
        return krakenGOContactLogFile;
    }
}
