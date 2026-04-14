//Use for testing endpoint logging

package com.example.Kraken_C2.Config.Logging;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
public class LoggingController {

    private static final Logger logger = LogManager.getLogger(LoggingController.class);

    @GetMapping("/log")
    public String logExample() {
        logger.info("Info level log example");
        logger.debug("Debug level log example");
        logger.error("Error level log example", new Exception("Example exception"));
        return "Logging has been demonstrated. Check the console and the log file!";
    }
}
