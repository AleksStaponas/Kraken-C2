# Kraken-C2 com.example.Kraken_C2.Cli.Commands

```text
                                                                                                ██              ██
██╗  ██╗██████╗  █████╗ ██╗  ██╗███████╗███╗   ██╗     ██████╗██████╗                             ████  ████████
██║ ██╔╝██╔══██╗██╔══██╗██║ ██╔╝██╔════╝████╗  ██║    ██╔════╝╚════██╗                          ████████  ████████
█████╔╝ ██████╔╝███████║█████╔╝ █████╗  ██╔██╗ ██║    ██║      █████╔╝                        ████████████  ██████
██╔═██╗ ██╔══██╗██╔══██║██╔═██╗ ██╔══╝  ██║╚██╗██║    ██║     ██╔═══╝                         ██████████████      ██
██║  ██╗██║  ██║██║  ██║██║  ██╗███████╗██║ ╚████║    ╚██████╗███████╗                        ██  ██████████      ██
╚═╝  ╚═╝╚═╝  ╚═╝╚═╝  ╚═╝╚═╝  ╚═╝╚══════╝╚═╝  ╚═══╝     ╚═════╝╚══════╝                        ████████████████████
                                                                                                  ██████████████
```

## Proxy com.example.Kraken_C2.Cli.Commands
- **start**: 
  - Information: Start a http proxy on set port and forwards all data to a chosen IP address
  - Example: ```start proxy/http```
 
  <details>
  <summary><b>Execution</b></summary>

  ```text

  Kraken > start proxy/http
  To configure the proxy server you will need to enter: 
  RHOST: The IP address of the server to forward data to 
  RPORT: The port of the server to forward data to 
  LPORT: The local port it will run on
  Enter RHOST
  127.0.0.1
  Enter RPORT
  1111
  Enter LPORT
  2222
  Starting proxy for 127.0.0.1:1111 on port 2222
  Proxy server started.

## Listeners

- **active-listeners**: 
  - Description: These commands start different listeners with different protocols
  - Example ```active-listeners```

  <details>
  <summary><b>Execution</b></summary>

  ```text

  Kraken > active-listeners
  Host / IP                 ID             Protocol   Port   Active
  -----------------------   -------------  --------  ----   ------
  IP:EXAMPLE-HOST/10.0.0.1 ID:2cBWIhn3Koj Protocol:http Port:1231 Status:true
  IP:EXAMPLE-HOST/10.0.0.1 ID:fK1l9AAOil5 Protocol:https Port:1232 Status:true
  IP:EXAMPLE-HOST/10.0.0.1 ID:iZDJblgKBLK Protocol:tcp Port:1233 Status:true
  IP:EXAMPLE-HOST/10.0.0.1 ID:00R3lf1FT2T Protocol:tcp Port:1234 Status:true

- **tcp**: 
  - Information: Starts a tcp listener on a chosen port
  - Example: ```tcp <port>```

  <details>
  <summary><b>Execution</b></summary>

  ```text
  Kraken > tcp
  Enter port of the TCP listener
  1234
  TCP listener started on port 1234

- **http**: 
  - Information: Starts http listener on chosen port
  - Example: ```http <port>```

  <details>
  <summary><b>Execution</b></summary>

  ``` text
  Kraken > http
  Enter port of HTTP listener
  1234
  Starting HTTP listener
  Server is running on port 1234

- **https**: 
  - Information: Starts https listener on chosen port with encryption
  - Example: ```https <port>```

  <details>
  <summary><b>Execution</b></summary>

  ```text
  Kraken > https
  Enter port of the HTTPS listener
  1234
  Enter the number of maximum concurrent visitors.
  10
  Starting HTTPS server

- **mtls**: 
  - Information: Starts a mtls listener on chosen port with encryption
  - Example: ```mtls <port>```

  <details>
  <summary><b>Execution</b></summary>

  ```text
  Kraken > mtls
  Enter port of the mtls listener
  1234
  Server running on port 1234

## com.example.Kraken_C2.Cli.Commands
- **license**: 
  - Information: Displays Kraken-C2's license
  - Example: ```license```
  
  <details>
  <summary><b>Execution</b></summary>

  ```text
  Kraken > license
  Welcome to Kraken C2. This tool is currently under development, so some features may not be fully functional.
  This tool has been made for research and educational purposes. If you want to report issues with the tool,
  such as bugs, you can report them on the GitHub repository. This would be greatly appreciated.
