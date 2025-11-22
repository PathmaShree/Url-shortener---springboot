import { useEffect } from "react";
import { useParams } from "react-router-dom";
import api from "../api/api";

export default function Redirector() {
    const { shortCode } = useParams();

    useEffect(() => {
        const redirect = async () => {
            try {
                const res = await api.get(`/urlMapping/redirect/${shortCode}`);
                
                
                const originalUrl = res.data;

                
                window.location.href = originalUrl;
            } 
            catch (err) {
                console.error("Redirect error:", err);
                alert("Invalid or expired short URL");
            }
        };
        redirect();
    }, [shortCode]);

    return <h2>Redirecting...</h2>;
}
