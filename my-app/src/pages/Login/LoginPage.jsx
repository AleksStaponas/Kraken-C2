import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate, Link } from 'react-router-dom';

function LoginPage() {
    const navigate = useNavigate();
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [error, setError] = useState('');
    const [loading, setLoading] = useState(false);

    const handleLogin = async () => {
        setError('');

        if (!username.trim() || !password.trim()) {
            setError('Please enter both username and password');
            return;
        }

        setLoading(true);

        try {
            const response = await axios.post(
                'http://localhost:8080/api/auth/login',
                { username, password },
                {
                    withCredentials: true,
                    headers: { 'Content-Type': 'application/json' }
                }
            );

            if (response.status === 200 || response.status === 201) {
                navigate('/menu');
            }
        } catch (err) {
            console.error('Login error:', err);

            let errorMessage = 'Login failed. Please try again.';

            if (err.response?.data) {
                const data = err.response.data;

                if (typeof data === 'string') {
                    errorMessage = data;
                }
                else if (typeof data === 'object') {
                    if (data.message) {
                        errorMessage = data.message;
                    } else if (data.error) {
                        errorMessage = data.error;
                    } else if (data.status === 401) {
                        errorMessage = 'Invalid username or password';
                    }
                }
            } else if (err.request) {
                errorMessage = 'Cannot connect to server.';
            }

            setError(errorMessage);
        } finally {
            setLoading(false);
        }
    };

    return (
        <div className="login-container">
            <div className="login-box">
                <h2>Login</h2>
                {error && <div className="error-message">{error}</div>}
                <input
                    type="text"
                    placeholder="Username"
                    value={username}
                    onChange={(e) => setUsername(e.target.value)}
                    disabled={loading}
                />
                <input
                    type="password"
                    placeholder="Password"
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                    onKeyPress={(e) => e.key === 'Enter' && handleLogin()}
                    disabled={loading}
                />
                <button onClick={handleLogin} disabled={loading}>
                    {loading ? 'Logging in...' : 'Login'}
                </button>
                <p>Not a member? <Link to="/signup">Register</Link></p>
            </div>
        </div>
    );
}

export default LoginPage;
