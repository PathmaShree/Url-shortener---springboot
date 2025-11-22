import React, { useState } from "react";
import api from "../api/api";

export default function CountVisits() {
  const [shortCode, setShortCode] = useState("");
  const [count, setCount] = useState(null);

  const fetchCount = async () => {
    try {
      const res = await api.get(`/urlAnalytics/count/${shortCode}`);
      setCount(res.data);
    } catch (err) {
      console.log(err);
    }
  };

  return (
    <div>
      <h2>Count Visits</h2>
      <input type="text" placeholder="Short Code" value={shortCode} onChange={(e) => setShortCode(e.target.value)} />
      <button onClick={fetchCount}>Get Count</button>
      {count !== null && <p>Total Visits: {count}</p>}
    </div>
  );
}
