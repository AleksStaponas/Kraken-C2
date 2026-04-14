package com.example.Kraken_C2.API.GOContact;

import com.example.Kraken_C2.API.GOContact.DataReceiver;
import com.example.Kraken_C2.Config.DirectoryValues;
import com.example.Kraken_C2.Config.Logging.LoggingController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;

@RestController
public class Controller {

    private static final Logger logger = LogManager.getLogger(LoggingController.class);
    private final DirectoryValues directoryValues;

    public Controller(DirectoryValues directoryValues) {
        this.directoryValues = directoryValues;
    }

    @PostMapping("/api/Backend/GOContact")
    public String getGOResponse(@RequestBody DataReceiver ob) {

        Date date = new Date();
        DataReceiver.Data.add(new DataReceiver(ob.getData()));

        String KrakenGOContactLogFile = directoryValues.krakenGOContactLogFile();

        for (DataReceiver d : DataReceiver.Data) {
            System.out.println(d.getData());
        }

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(KrakenGOContactLogFile,true));

            writer.write("{Date:"+ LocalDateTime.now() + "}   {Data: " + ob.getData() + "}");
            writer.newLine();
            writer.close();

           logger.debug("Response has been received");
           return("Response has been received");

        }
        catch (IOException e) {
            logger.error("An error occurred: {}", e.getMessage());
            return "An error occurred";
        }
    }
}
