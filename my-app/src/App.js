import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Menu from './pages/Menu/Menu';
import Configure from "./pages/Configure/Configure";
import Terminal from "./pages/Terminal/Terminal";
import Botnet from "./pages/Botnet/Botnet";
import FileServer from "./pages/FileServer/FileServer";
import Logs from "./pages/Logs/Logs";
import LoginPage from "./pages/Login/LoginPage";
import SignupPage from "./pages/SignupPage/SignupPage";

function App() {
    return (
        <Router>
            <div className="App">
                <Routes>
                    <Route path="/login" element={<LoginPage />} />
                    <Route path="/signup" element={<SignupPage />} />
                    <Route path="/menu" element={<Menu />} />
                    <Route path="/configure" element={<Configure />} />
                    <Route path="/botnet" element={<Botnet />} />
                    <Route path="/terminal" element={<Terminal />} />
                    <Route path="/file-server" element={<FileServer />} />
                    <Route path="/logs" element={<Logs />} />
                </Routes>
            </div>
        </Router>
    );
}

export default App;
