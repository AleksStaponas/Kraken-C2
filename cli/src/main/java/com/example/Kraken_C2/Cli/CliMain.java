package com.example.Kraken_C2.Cli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CliMain {

    static String BootASCII = """                                                                                                
                                                                                                        ██              ██ 
        ██╗  ██╗██████╗  █████╗ ██╗  ██╗███████╗███╗   ██╗     ██████╗██████╗                             ████  ████████     
        ██║ ██╔╝██╔══██╗██╔══██╗██║ ██╔╝██╔════╝████╗  ██║    ██╔════╝╚════██╗                          ████████  ████████ 
        █████╔╝ ██████╔╝███████║█████╔╝ █████╗  ██╔██╗ ██║    ██║      █████╔╝                        ████████████  ██████
        ██╔═██╗ ██╔══██╗██╔══██║██╔═██╗ ██╔══╝  ██║╚██╗██║    ██║     ██╔═══╝                         ██████████████      ██
        ██║  ██╗██║  ██║██║  ██║██║  ██╗███████╗██║ ╚████║    ╚██████╗███████╗                        ██  ██████████      ██
        ╚═╝  ╚═╝╚═╝  ╚═╝╚═╝  ╚═╝╚═╝  ╚═╝╚══════╝╚═╝  ╚═══╝     ╚═════╝╚══════╝                        ████████████████████ 
                                                                                                          ██████████████ 
                                                                                
                                                                                                                                         
        """;

    public static void main(String[] args) {
        System.out.println(BootASCII);
        SpringApplication.run(CliMain.class, args);
    }

}
