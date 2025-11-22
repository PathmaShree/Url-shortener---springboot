import React,{useState,useEffect} from 'react';
import api from '../api/api'

export default function UrlList(){
    const[urls,setUrls] = useState([]);

    useEffect(()=>{
        api.get("/urlMapping/getAll")
        .then(res=>setUrls(res.data))
        .catch(err=>console.log(err))
    },[]);

    return(
        <div>
            <h2>Available Urls</h2>
            <ul>
    {urls.map(u => (
        <li key={u.shortUrl}>
            {u.originalUrl} → 
            <a href={`/redirect/${u.shortCode}`} target="_blank">
                {u.shortUrl}
            </a>
            (Expire: {u.expireAt})
        </li>
    ))}
</ul>

        </div>
    );
}