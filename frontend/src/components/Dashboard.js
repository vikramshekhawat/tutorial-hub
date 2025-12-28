import React from 'react';
import { useNavigate } from 'react-router-dom';
import Footer from './Footer';
import './Dashboard.css';

function Dashboard({ user, onLogout }) {
  const navigate = useNavigate();

  const handleLogout = () => {
    onLogout();
    navigate('/signin');
  };

  return (
    <div className="dashboard-container">
      <div className="dashboard-card">
        <div className="dashboard-header">
          <h1>Welcome to Dashboard</h1>
          <button onClick={handleLogout} className="logout-button">
            Logout
          </button>
        </div>

        <div className="user-info">
          <div className="info-item">
            <span className="info-label">Username:</span>
            <span className="info-value">{user?.username}</span>
          </div>
          <div className="info-item">
            <span className="info-label">Email:</span>
            <span className="info-value">{user?.email}</span>
          </div>
          <div className="info-item">
            <span className="info-label">Role:</span>
            <span className={`info-value role-badge role-${user?.role?.toLowerCase()}`}>
              {user?.role}
            </span>
          </div>
        </div>

        <div className="dashboard-content">
          <h2>Hello World API</h2>
          <p>You have successfully authenticated!</p>
          <p>Your role: <strong>{user?.role}</strong></p>
        </div>
      </div>
      <Footer />
    </div>
  );
}

export default Dashboard;

