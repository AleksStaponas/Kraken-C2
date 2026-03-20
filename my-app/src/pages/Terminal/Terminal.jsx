import React, { useEffect, useState } from 'react';
import './Terminal.module.style.css';
import { Link, NavLink } from "react-router-dom";
import axios from "axios";

const Terminal = () => {
    const [command, setCommand] = useState("");
    const [responses, setResponses] = useState([]);

    useEffect(() => {
        import('./Terminal.module.style.css');
        const link = document.createElement('link');
        link.rel = 'stylesheet';
        link.href = 'https://cdn.boxicons.com/3.0.6/fonts/basic/boxicons.min.css';
        document.head.appendChild(link);

        return () => {
            document.head.removeChild(link);
        };
    }, []);

    const sendCommand = async (e) => {
        e.preventDefault();

        try {
            const result = await axios.post(
                'http://localhost:8080/api/terminal/run',
                { cmd: command }
            );

            setResponses((prevResponses) => [
                ...prevResponses,
                result.data.output || 'Not valid command'
            ]);
            console.log('Command sent successfully');
            setCommand("");
        } catch (error) {
            setResponses((prevResponses) => [
                ...prevResponses,
                "Error: " + error.message
            ]);
            console.log('Sending command failed', error);
        }
    };

    return (
        <div>
            <nav>
                <a href="#">Documentation</a>
                <a href="#">Buy me a coffee</a>
                <a href="https://github.com/AleksStaponas/CobaltLock">Github</a>
                <a id="Menu">Menu</a>
            </nav>

            <header className="header">
                <div className="container">
                    <nav className="terminal">
                        <p>Device terminal</p>
                        <br/>

                        {responses.map((response, index) => (
                            <p key={index}>[username@ip]~$ {response}</p>
                        ))}

                        <form onSubmit={sendCommand}>
                            <input
                                className="input-bar"
                                name="command"
                                value={command}
                                onChange={(e) => setCommand(e.target.value)}
                                placeholder="Enter command"
                            />
                            <button type="submit" className="Submit-button">Submit</button>
                        </form>
                        <br/>
                    </nav>
                    <div className="Bot-terminal">
                        <p>Bot Terminal</p>
                        <br />
                        <p>[username@ip]~$ sudo apt install opsec</p>
                    </div>
                </div>
            </header>

            <div className="side-nav">
                <a href="#" className="logo">
                    <img src="logo.png" className="logo-img" alt="Logo" />
                </a>
                <ul className="nav-links">
                    <li>
                        <NavLink to="/menu">
                            <i className="bx bxs-menu"></i>
                            <span>Menu</span>
                        </NavLink>
                    </li>
                    <li>
                        <NavLink to="/configure">
                            <i className="bx bxs-cog"></i>
                            <span>Configure</span>
                        </NavLink>
                    </li>
                    <li>
                        <NavLink to="/botnet">
                            <i className="bx bxs-desktop"></i>
                            <span>Botnet</span>
                        </NavLink>
                    </li>
                    <li>
                        <NavLink to="/terminal">
                            <i className="bx bxs-terminal"></i>
                            <span>Terminal</span>
                        </NavLink>
                    </li>
                    <li>
                        <NavLink to="/file-server">
                            <i className="bx bxs-server"></i>
                            <span>File-server</span>
                        </NavLink>
                    </li>
                    <li>
                        <NavLink to="/logs">
                            <i className="bx bxs-file"></i>
                            <span>Logs</span>
                        </NavLink>
                    </li>
                </ul>
            </div>
        </div>
    );
};

export default Terminal;
