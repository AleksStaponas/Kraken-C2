# Kraken C2
```
                                                                                                ██              ██
██╗  ██╗██████╗  █████╗ ██╗  ██╗███████╗███╗   ██╗     ██████╗██████╗                             ████  ████████
██║ ██╔╝██╔══██╗██╔══██╗██║ ██╔╝██╔════╝████╗  ██║    ██╔════╝╚════██╗                          ████████  ████████
█████╔╝ ██████╔╝███████║█████╔╝ █████╗  ██╔██╗ ██║    ██║      █████╔╝                        ████████████  ██████
██╔═██╗ ██╔══██╗██╔══██║██╔═██╗ ██╔══╝  ██║╚██╗██║    ██║     ██╔═══╝                         ██████████████      ██
██║  ██╗██║  ██║██║  ██║██║  ██╗███████╗██║ ╚████║    ╚██████╗███████╗                        ██  ██████████      ██
╚═╝  ╚═╝╚═╝  ╚═╝╚═╝  ╚═╝╚═╝  ╚═╝╚══════╝╚═╝  ╚═══╝     ╚═════╝╚══════╝                        ████████████████████
                                                                                                  ██████████████
```

## Information

This branch will focus on transforming CobaltLock into a fully functional, ethical full-stack C2 (Command and Control) server, utilizing the following technologies:
<p align="center">
  <a href="https://skillicons.dev">
    <img src="https://skillicons.dev/icons?i=java,html,css,js,react,postgres,mongodb" />
  </a>
</p>

Current features
- Lightweight C2 shell supporting HTTP and HTTPS commands (payload building not included).
- Basic website (still in progress)

Command demonstration

```
Kraken > http
Enter port of HTTP listener
1234
Starting HTTP listener
Server is running on port 1234
```

```
Kraken > https
Enter port of the HTTPS listener
1234
Enter the number of maximum concurrent visitors.
10
Starting HTTPS server
```

```
Kraken > start proxy/http
To configure the proxy server you will need to enter: 
RHOST: The IP address of the server to forward data to 
RPORT: The port of the server to forward data to 
LPORT: The local port it will run on
Enter RHOST
127.0.0.1
Enter RPORT
4444
Enter LPORT
5555
Starting proxy for 127.0.0.1:4444 on port 5555
Proxy server started.
```

```
Kraken > license
Welcome to Kraken C2. This tool is currently under development, so some features may not be fully functional.
This tool has been made for research and educational purposes. If you want to report issues with the tool,
such as bugs, you can report them on the GitHub repository. This would be greatly appreciated.
```
Features planned to be implemented 

- User Authentication: Implementing a secure login system using (HttpOnly cookies) to access the control panel.
- Basic payload creation with simple encoding (Base 64)

## Legal Disclaimer

This software is provided **strictly for educational, research, and ethical practice purposes only**.

-  **Do NOT use this tool on any system you do not own or have explicit permission to test.**
-  **Unauthorized use of this software may be illegal and is strictly prohibited.**
-  **The author takes no responsibility for any damage, data loss, or legal consequences resulting from misuse.**

By using this software, you agree to use it **ethically, lawfully**, and in **controlled environments such as virtual labs, or testing networks with legal permission**.

This tool is intended to help raise awareness and understanding of security threats — **not to promote or enable criminal activity**.

> **If anything is still unclear, read the full [Code of Conduct](CODE_OF_CONDUCT.md). The author is not responsible for misuse or misunderstanding of this software.**
