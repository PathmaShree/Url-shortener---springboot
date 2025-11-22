import React,{useState} from 'react';
import api from '../api/api';

export default function CreateUrl(){
    const[originalUrl,setOriginalUrl] = useState("");
    const[expiryHours,setexpiryHours] = useState("");
    const[shortUrl,setShortUrl] = useState(null);
    const[error,setError] = useState("");

    const handleSubmit = async(e)=>{
        e.preventDefault();
        try{
            const res =await api.post("/urlMapping/createShorten",{originalUrl,expiryHours});
            setShortUrl(res.data.shortUrl);
            setError("");
        }
        catch(err){
            setError(err.response?.data ||"Something went wrong");
        }
    };

    return(
        <div>
            <h2>Creating Short Url</h2>
            <form onSubmit={handleSubmit}>
                <input type="text" placeholder='Original Url' value={originalUrl} onChange={e=>setOriginalUrl(e.target.value)}/>
                <input type="number" placeholder='Expiry Hours' value={expiryHours} onChange={e=>setexpiryHours(e.target.value)}/>
                <button type="submit">Create Short Url</button>
            </form>
            {shortUrl && (
    <p>
        Short Url : 
        <a href={`/redirect/${shortUrl.split('/').pop()}`} target="_blank">
            {shortUrl}
        </a>
    </p>
)}

            {error && <p style={{color:'red'}}>{error}</p>}
        </div>
    );
}