package com.example.Kraken_C2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiMain {

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
        SpringApplication.run(ApiMain.class, args);
    }

}
