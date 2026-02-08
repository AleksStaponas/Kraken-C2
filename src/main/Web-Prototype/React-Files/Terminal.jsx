import React, { useEffect } from 'react';
import './style.css';
import {Link} from "react-router-dom";

const Terminal = () => {
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
                <a href="#" id="Menu">Terminal</a>
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
                        <Link to="/menu">
                            <i className="bx bxs-menu"></i>
                            <span>Menu</span>
                        </Link>
                    </li>
                    <li>
                        <Link to="/configure">
                            <i className="bx bxs-cog"></i>
                            <span>Configure</span>
                        </Link>
                    </li>
                    <li>
                        <Link to="/botnet">
                            <i className="bx bxs-desktop"></i>
                            <span>Botnet</span>
                        </Link>
                    </li>
                    <li>
                        <Link to="/terminal">
                            <i className="bx bxs-terminal"></i>
                            <span>Terminal</span>
                        </Link>
                    </li>
                    <li>
                        <Link to="/file-server">
                            <i className="bx bxs-server"></i>
                            <span>File-server</span>
                        </Link>
                    </li>
                    <li>
                        <Link to="/logs">
                            <i className="bx bxs-file"></i>
                            <span>Logs</span>
                        </Link>
                    </li>
                </ul>
            </div>
        </div>
    );
};

export default Terminal;
