package com.example.SpringShell;

import com.sun.net.httpserver.*;
import org.springframework.shell.command.annotation.Command;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import javax.net.ssl.*;
import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@ShellComponent
public class Commands {

    public static int portNumberCheck(int Port) {

        Scanner scanner = new Scanner(System.in);
        if (Port >= 1 && Port <= 65535) {
            return Port;
        } else {
            System.out.println("Invalid port number");
            int port;
            while (true) {
                System.out.print("Enter a valid port number (1-65535): ");
                port = scanner.nextInt();
                if (port >= 1 && port <= 65535) {
                    break;
                } else {
                    System.out.println("Invalid port number. Please try again.");
                }
            }
            return port;
        }
    }

    public static String IDGenerator(int length) {
        String alphanumericCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuv";

        StringBuilder randomString = new StringBuilder(10);
        Random random = new Random();

        for (int i = 0; i <= 10; i++) {
                int randomIndex = random.nextInt(alphanumericCharacters.length());
                char randomChar = alphanumericCharacters.charAt(randomIndex);
                randomString.append(randomChar);
            }
        return randomString.toString();
    }

    public static String processWriter(String ID,String Protocol,String IP,int Port, boolean Active){

        try {
            FileWriter myWriter = new FileWriter("RunningServices.csv", true);
            myWriter.write(IP + "," + ID + "," + Protocol + "," + Port + "," + Active + "\n");
            myWriter.close();
            //System.out.println("Successfully wrote to the file."); Use for debugging
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

        return "";

    }


    @ShellComponent
    public static class listeners {

        @ShellMethod(key = "https", value = "Start HTTPS listener on a specified port")
        public String httpsListener() {

            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter port of the HTTPS listener");
            int port = scanner.nextInt();
            portNumberCheck(port);

            System.out.println("Enter the number of maximum concurrent visitors.");
            int visitorThread = scanner.nextInt();

            if (visitorThread <= 0) {
                System.out.println("Invalid set number");
                return "";
            }

            try {
                InetSocketAddress Inet_Address = new InetSocketAddress(port);

                HttpsServer HTTPS_Server = HttpsServer.create(Inet_Address, 0);
                SSLContext SSL_Context = SSLContext.getInstance("TLS");

                char[] Password = "12345678".toCharArray();
                KeyStore Key_Store = KeyStore.getInstance("JKS");
                FileInputStream Input_Stream = new FileInputStream("keystore.jks");
                Key_Store.load(Input_Stream, Password);

                KeyManagerFactory Key_Manager = KeyManagerFactory.getInstance("SunX509");
                Key_Manager.init(Key_Store, Password);

                TrustManagerFactory Trust_Manager = TrustManagerFactory.getInstance("SunX509");
                Trust_Manager.init(Key_Store);

                SSL_Context.init(Key_Manager.getKeyManagers(), Trust_Manager.getTrustManagers(), null);
                HTTPS_Server.setHttpsConfigurator(new HttpsConfigurator(SSL_Context) {
                    public void configure(HttpsParameters params) {
                        try {
                            SSLContext SSL_Context = getSSLContext();
                            SSLEngine SSL_Engine = SSL_Context.createSSLEngine();
                            params.setNeedClientAuth(false);
                            params.setCipherSuites(SSL_Engine.getEnabledCipherSuites());
                            params.setProtocols(SSL_Engine.getEnabledProtocols());

                            SSLParameters SSL_Parameters = SSL_Context.getSupportedSSLParameters();
                            params.setSSLParameters(SSL_Parameters);

                        } catch (Exception ex) {
                            System.out.println("Failed to create the HTTPS port");
                        }
                    }
                });
                HTTPS_Server.createContext("/", new MyHTTPSHandler());
                HTTPS_Server.setExecutor(Executors.newFixedThreadPool(visitorThread));
                HTTPS_Server.start();

                String ID = IDGenerator(10);
                String Protocol = "https";
                InetAddress IP = InetAddress.getLocalHost();
                int Port = port;
                boolean Active = true;

                processWriter(ID,Protocol, String.valueOf(IP),Port,Active);

                return "Starting HTTPS server";
            } catch (Exception exception) {
                exception.printStackTrace();
                return "Failed to create HTTPS server on port " + port;
            }
        }

        public static class MyHTTPSHandler implements HttpHandler {
            @Override
            public void handle(HttpExchange x) throws IOException {
                String Response = "response";
                HttpsExchange HTTPS_Exchange = (HttpsExchange) x;
                x.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
                x.sendResponseHeaders(200, Response.getBytes().length);
                OutputStream Output_Stream = x.getResponseBody();
                Output_Stream.write(Response.getBytes());
                Output_Stream.close();
            }


        @ShellMethod(key = "http", value = "Start HTTP listener on a specified port")
        public String httpListener() {

            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter port of HTTP listener");
            int port = scanner.nextInt();

            System.out.println("Starting HTTP listener");

            try {
                HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);

                server.createContext("/", new MyHTTPHandler());

                server.setExecutor(null);
                server.start();

                String ID = IDGenerator(10);
                String Protocol = "http";
                InetAddress IP = InetAddress.getLocalHost();
                int Port = port;
                boolean Active = true;

                processWriter(ID,Protocol, String.valueOf(IP),Port,Active);

                return ("Server is running on port " + port);
            } catch (IOException e) {
                return ("Error starting the server: " + e.getMessage());
            }

        }

        static class MyHTTPHandler implements HttpHandler {
            @Override
            public void handle(HttpExchange exchange) throws IOException {
                String response = "Hello, this is a simple HTTP server response!";
                exchange.sendResponseHeaders(200, response.length());
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            }
        }
    }

    @ShellComponent
    public static class Implants {

        private final Map<String, Runnable> implants = new HashMap<>();

        public Implants() {
            implants.put("implant/http/option1", () -> {
                System.out.println("Displays options");
            });
            implants.put("implant/http/option2", () -> {
                System.out.println("Displays options");
            });
            implants.put("implant/dns/beacon", () -> {
                System.out.println("Displays options");
            });
            implants.put("implant/tcp/stealth", () -> {
                System.out.println("Displays options");
            });
        }

        @ShellMethod(key = "generate ", value = "Generate an implant. Example: generate implant/http/option1")
        public String generateImplant(String path) {
            Runnable description = implants.get(path.toLowerCase());
            if(description != null) {
                description.run();
                return"";
            } else {
                return "Unknown implant. Available implants: " + String.join(", ", implants.keySet());
            }
        }

    }

    @ShellComponent
    public class Proxy {
        private final Map<String, Runnable> proxy = new HashMap<>();

        public Proxy() {
            proxy.put("proxy/http", () -> {

                try {
                    Scanner scanner = new Scanner(System.in);

                    System.out.println("To configure the proxy server you will need to enter: \n" +
                            "RHOST: The IP address of the server to forward data to \n" +
                            "RPORT: The port of the server to forward data to \n" +
                            "LPORT: The local port it will run on");

                    System.out.println("Enter RHOST");
                    String Proxy_Host = scanner.next();

                    System.out.println("Enter RPORT");
                    int Remote_Port = scanner.nextInt();

                    System.out.println("Enter LPORT");
                    int Local_Port = scanner.nextInt();

                    System.out.println("Starting proxy for " + Proxy_Host + ":" + Remote_Port + " on port " + Local_Port);

                    String ID = IDGenerator(10);
                    String Protocol = "http";
                    InetAddress IP = InetAddress.getLocalHost();
                    int Port = Local_Port;
                    boolean Active = true;

                    processWriter(ID,Protocol, String.valueOf(IP),Port,Active);

                    new Thread(() -> {
                        try {
                            Run_Server(Proxy_Host, Remote_Port, Local_Port);
                        } catch (IOException e) {
                            System.err.println("Error running proxy server: " + e.getMessage());
                        }
                    }).start();

                    System.out.println("Proxy server started in the background.");

                } catch (Exception e) {
                    System.err.println(e);
                }
            });

            proxy.put("proxy/https", () -> {
                System.out.println("Starts proxy server");
            });
        }

        public static void Run_Server(String Proxy_Host, int Remote_Port, int Local_Port) throws IOException {
            ServerSocket Server_Socket = new ServerSocket(Local_Port);
            final byte[] Request = new byte[1024];
            byte[] Reply = new byte[4096];
            while (true) {
                Socket Socket_Client = null, Socket_Server = null;
                try {
                    Socket_Client = Server_Socket.accept();
                    final InputStream InputStreamClient = Socket_Client.getInputStream();
                    final OutputStream OutputStreamClient = Socket_Client.getOutputStream();

                    try {
                        Socket_Server = new Socket(Proxy_Host, Remote_Port);
                    } catch (IOException e) {
                        PrintWriter out = new PrintWriter(OutputStreamClient);
                        out.print("The Proxy Server could not connect to " + Proxy_Host + ":" + Remote_Port
                                + ":\n" + e + "\n");
                        out.flush();
                        Socket_Client.close();
                        continue;
                    }

                    final InputStream InputStreamServer = Socket_Server.getInputStream();
                    final OutputStream OutputStreamServer = Socket_Server.getOutputStream();

                    Thread New_Thread = new Thread() {
                        public void run() {
                            int Bytes_Read;
                            try {
                                while ((Bytes_Read = InputStreamClient.read(Request)) != -1) {
                                    OutputStreamServer.write(Request, 0, Bytes_Read);
                                    OutputStreamServer.flush();
                                }
                            } catch (IOException e) {
                            }

                            try {
                                OutputStreamServer.close();
                            } catch (IOException e) {
                            }
                        }
                    };

                    New_Thread.start();
                    int Bytes_Read;
                    try {
                        while ((Bytes_Read = InputStreamServer.read(Reply)) != -1) {
                            OutputStreamClient.write(Reply, 0, Bytes_Read);
                            OutputStreamClient.flush();
                        }
                    } catch (IOException e) {
                    }
                    OutputStreamClient.close();
                } catch (IOException e) {
                    System.err.println(e);
                } finally {
                    try {
                        if (Socket_Server != null) Socket_Server.close();
                        if (Socket_Client != null) Socket_Client.close();
                    } catch (IOException e) {
                    }
                }
            }
        }

        @ShellMethod(key = "start ", value = "Generate an proxy. Example: start proxy/http")
        public String generateImplant(String path) {
            Runnable description = proxy.get(path.toLowerCase());
            if(description != null) {
                description.run();
                return"";
            } else {
                return "Unknown proxy. Available proxy: " + String.join(", ", proxy.keySet());
            }
        }

    }

    @ShellMethod(key = "license", value = "Display Kraken C2's license")
    public String license() {
        return "Welcome to Kraken C2. This tool is currently under development, so some features may not be fully functional.\n" +
                "This tool has been made for research and educational purposes. If you want to report issues with the tool,\n" +
                "such as bugs, you can report them on the GitHub repository. This would be greatly appreciated.";
         }
    }
}
