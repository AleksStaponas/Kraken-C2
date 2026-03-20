import { useNavigate } from "react-router-dom";
import axios from "axios";

export default function useLogout() {
    const navigate = useNavigate();

    const logout = async () => {
        try {
            console.log("Attempting to logout");
            await axios.post(
                "http://localhost:8080/api/auth/logout",
                {},
                { withCredentials: true }
            );
            console.log("Logged out successfully");
        } catch (error) {
            console.error("Logout error:", error);
        } finally {
            navigate("/");
        }
    };

    return logout;
}
