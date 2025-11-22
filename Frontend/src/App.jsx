import React from 'react';
import{BrowserRouter as Router,Routes,Route,Link} from "react-router-dom";

import CreateUrl from './components/CreateUrl';
import UrlList from './components/UrlList';
import Analytics from './components/Analytics';
import CountVisits from './components/CountVisits';
import Redirector from './components/Redirector';
import "./App.css";

function App(){
  return(
    <Router>
      <nav>
        <Link to="/">Create Url</Link> 
        <Link to="/list">Available Urls</Link> 
        <Link to="/analytics">Fetch Analytics</Link> 
        <Link to="/count">Count Visits</Link> 
      </nav>

      <Routes>
        <Route path="/" element={<CreateUrl/>}/>
        <Route path="/list" element={<UrlList/>}/>
        <Route path="/analytics" element={<Analytics/>}/>
        <Route path="/count" element={<CountVisits/>}/>
        <Route path="/redirect/:shortCode" element={<Redirector />} />
      </Routes>
    </Router>
  );
}

export default App;