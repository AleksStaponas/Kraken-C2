import { useNavigate } from "react-router-dom";
import axios from "axios";

export default function validateToken() {
    const navigate = useNavigate();

const validate = async () => {
    try {
        axios.post(
            'http://localhost:8080/api/auth/validateToken',
            {},
            { withCredentials: true }
        )
            .then(() => {
                console.log('Token validated successfully');
                setLoading(false);
            })
    } catch (error) {
        console.log('Token validation failed, redirecting to login');
    } finally {
        navigate('/login');
    }
}

   return validateToken;

}
