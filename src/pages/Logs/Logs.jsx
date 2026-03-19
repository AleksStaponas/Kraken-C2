import React, { useEffect } from 'react';
import './style.css';
import {Link, NavLink} from "react-router-dom";

const Logs = () => {
    useEffect(() => {
        const link = document.createElement('link');
        link.rel = 'stylesheet';
        link.href = 'https://cdn.boxicons.com/3.0.6/fonts/basic/boxicons.min.css';
        document.head.appendChild(link);

        return () => {
            document.head.removeChild(link);
        };
    }, []);

    return (
        <div>
            <nav>
                <a href="#">Documentation</a>
                <a href="#">Buy me a coffee</a>
                <a href="#">Github</a>
                <a href="#" id="Menu">Logs</a>
            </nav>

            <header className="header">
                <div className="container"></div>
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

export default Logs;
