import React, { useEffect } from 'react';
import './Configure.module.style.css';
import {Link, NavLink} from "react-router-dom";
import useLogout from "../../components/hooks/Logout";
import axios from "axios";

const Configure = () => {

    const logout = useLogout();

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
            <nav className="pages">
                <a href="https://github.com/AleksStaponas/Kraken-C2">Documentation</a>
                <a className="space"> | </a>
                <a href="#">Buy me a coffee</a>
                <a className="space"> | </a>
                <a href="https://github.com/AleksStaponas/Kraken-C2">Github</a>
                <a id="Menu">Menu</a>
            </nav>

            <header className="header"></header>

            <div className="side-nav">
                <a href="#" className="logo">
                    <img src="logo.png" className="logo-img" alt="Logo"/>
                </a>
                <ul className="nav-links">
                    <li>
                        <NavLink to="/menu">
                            <i className="bx bxs-menu"></i>
                            <span>&nbsp;&nbsp;Menu</span>
                        </NavLink>
                    </li>
                    <li>
                        <NavLink to="/configure">
                            <i className="bx bxs-cog"></i>
                            <span>&nbsp;&nbsp;Configure</span>
                        </NavLink>
                    </li>
                    <li>
                        <NavLink to="/botnet">
                            <i className="bx bxs-desktop"></i>
                            <span>&nbsp;&nbsp;Botnet</span>
                        </NavLink>
                    </li>
                    <li>
                        <NavLink to="/terminal">
                            <i className="bx bxs-terminal"></i>
                            <span>&nbsp;&nbsp;Terminal</span>
                        </NavLink>
                    </li>
                    <li>
                        <NavLink to="/file-server">
                            <i className="bx bxs-server"></i>
                            <span>&nbsp;&nbsp;File-server</span>
                        </NavLink>
                    </li>
                    <li>
                        <NavLink to="/logs">
                            <i className="bx bxs-file"></i>
                            <span>&nbsp;&nbsp;Logs</span>
                        </NavLink>
                    </li>
                </ul>
                <br/>
                <div className="sign-out-div" onClick={logout}>
                    <p className="sign-out">Sign out</p>
                    <i className="bx bx-arrow-out-right-square-half"/>
                </div>

                <br/>
                <p className="version">version 0.0.3</p>
            </div>
        </div>
    );
};

export default Configure;
