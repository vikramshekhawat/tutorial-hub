import React, { useState, useEffect } from 'react';
import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom';
import SignUp from './components/SignUp';
import SignIn from './components/SignIn';
import Dashboard from './components/Dashboard';
import TutorialHome from './components/TutorialHome';
import './App.css';

function App() {
  const [isAuthenticated, setIsAuthenticated] = useState(false);
  const [user, setUser] = useState(null);

  useEffect(() => {
    const token = localStorage.getItem('token');
    const userData = localStorage.getItem('user');
    if (token && userData) {
      setIsAuthenticated(true);
      setUser(JSON.parse(userData));
    }
  }, []);

  const handleLogin = (userData, token) => {
    localStorage.setItem('token', token);
    localStorage.setItem('user', JSON.stringify(userData));
    setIsAuthenticated(true);
    setUser(userData);
  };

  const handleLogout = () => {
    localStorage.removeItem('token');
    localStorage.removeItem('user');
    setIsAuthenticated(false);
    setUser(null);
  };

  return (
    <Router>
      <div className="App">
        <Routes>
          <Route 
            path="/signup" 
            element={
              isAuthenticated ? 
                <Navigate to="/home" /> : 
                <SignUp onLogin={handleLogin} />
            } 
          />
          <Route 
            path="/signin" 
            element={
              isAuthenticated ? 
                <Navigate to="/home" /> : 
                <SignIn onLogin={handleLogin} />
            } 
          />
          <Route 
            path="/home" 
            element={
              isAuthenticated ? 
                <TutorialHome user={user} onLogout={handleLogout} /> : 
                <Navigate to="/signin" />
            } 
          />
          <Route 
            path="/dashboard" 
            element={
              isAuthenticated ? 
                <Dashboard user={user} onLogout={handleLogout} /> : 
                <Navigate to="/signin" />
            } 
          />
          <Route path="/" element={<Navigate to={isAuthenticated ? "/home" : "/signin"} />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;

