import React,{useState} from 'react';
import api from "../api/api";

export default function Analytics(){
    const [shortCode, setShortCode] = useState("");
    const [analytics, setAnalytics] = useState([]);

    const fetchAnalytics = async () => {
        try {
            const res = await api.get(`/urlMapping/getAnalytics/${shortCode}`);
            setAnalytics(res.data);
        } catch(err) {
            console.log(err);
        }
    }

    return (
        <div>
            <h2>Url Analytics</h2>
            <input
                type="text"
                placeholder="Short Code"
                value={shortCode}
                onChange={(e) => setShortCode(e.target.value)}
            />

            <button onClick={fetchAnalytics}>Fetch Analytics</button>

            <ul>
                {analytics.map((a, idx) => (
                    <li key={idx}>
                        {a.accessTime} - {a.ipAddress} - {a.browser} - {a.deviceType}
                    </li>
                ))}
            </ul>
        </div>
    );
}
