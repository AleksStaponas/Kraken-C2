package com.example.SpringShell;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringShellApplication {

	public static void main(String[] args) {

        String BootASCII = """                                                                                                
                                                                                                        ██              ██ 
        ██╗  ██╗██████╗  █████╗ ██╗  ██╗███████╗███╗   ██╗     ██████╗██████╗                             ████  ████████     
        ██║ ██╔╝██╔══██╗██╔══██╗██║ ██╔╝██╔════╝████╗  ██║    ██╔════╝╚════██╗                          ████████  ████████ 
        █████╔╝ ██████╔╝███████║█████╔╝ █████╗  ██╔██╗ ██║    ██║      █████╔╝                        ████████████  ██████
        ██╔═██╗ ██╔══██╗██╔══██║██╔═██╗ ██╔══╝  ██║╚██╗██║    ██║     ██╔═══╝                         ██████████████      ██
        ██║  ██╗██║  ██║██║  ██║██║  ██╗███████╗██║ ╚████║    ╚██████╗███████╗                        ██  ██████████      ██
        ╚═╝  ╚═╝╚═╝  ╚═╝╚═╝  ╚═╝╚═╝  ╚═╝╚══════╝╚═╝  ╚═══╝     ╚═════╝╚══════╝                        ████████████████████ 
                                                                                                          ██████████████ 
                                                                                
                                                                                                                                         
        """;

        System.out.println(BootASCII);
		SpringApplication.run(SpringShellApplication.class, args);
	}
}
