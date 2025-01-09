import React from 'react';
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import BillEntryPage from './BillEntryPage';
import ViewBill from './ViewBill';
import './App.css';

function App() {
  return(
    <Router>
      <div class='container'>
        <h1 align='center' >Bill Management System</h1>
        <nav>
          <ul>
            <li>
              <Link to='/addbill'>Add Bill</Link>
            </li>
            <li>
              <Link to='/viewbill'>View Bill</Link>
            </li>
          </ul>
        </nav>
      <Routes>
        <Route path='/addbill' element={<BillEntryPage />} />
        <Route path = '/viewbill' element ={<ViewBill /> } />
      </Routes>
      </div>
    </Router>
  );
}

export default App;