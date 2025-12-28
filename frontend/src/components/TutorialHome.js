import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import { getTechnologies } from '../services/api';
import Footer from './Footer';
import './TutorialHome.css';

function TutorialHome({ user, onLogout }) {
  const [technologies, setTechnologies] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState('');
  const navigate = useNavigate();

  useEffect(() => {
    loadTechnologies();
  }, []);

  const loadTechnologies = async () => {
    try {
      setLoading(true);
      const data = await getTechnologies();
      setTechnologies(data);
      setError('');
    } catch (err) {
      setError('Failed to load technologies. Please try again.');
      console.error('Error loading technologies:', err);
    } finally {
      setLoading(false);
    }
  };

  const handleTechnologyClick = (technologyId, technologyName) => {
    // Navigate to technology tutorials page (to be implemented in next step)
    navigate(`/tutorials/${technologyId}`);
  };

  const handleLogout = () => {
    onLogout();
    navigate('/signin');
  };

  return (
    <div className="tutorial-home">
      <header className="tutorial-header">
        <div className="header-content">
          <h1>📚 Tutorial Hub</h1>
          <div className="user-info-header">
            <span className="welcome-text">Welcome, {user?.username}!</span>
            <button onClick={handleLogout} className="logout-btn">Logout</button>
          </div>
        </div>
      </header>

      <main className="tutorial-main">
        <div className="container">
          <h2 className="section-title">Choose a Technology to Learn</h2>
          <p className="section-subtitle">Select a technology to start your learning journey</p>

          {loading && (
            <div className="loading-container">
              <div className="spinner"></div>
              <p>Loading technologies...</p>
            </div>
          )}

          {error && (
            <div className="error-container">
              <p>{error}</p>
              <button onClick={loadTechnologies} className="retry-btn">Retry</button>
            </div>
          )}

          {!loading && !error && (
            <div className="technologies-grid">
              {technologies.map((tech) => (
                <div
                  key={tech.id}
                  className="technology-card"
                  onClick={() => handleTechnologyClick(tech.id, tech.name)}
                >
                  <div className="tech-icon">{tech.iconUrl || '📖'}</div>
                  <h3 className="tech-name">{tech.name}</h3>
                  <p className="tech-description">{tech.description}</p>
                  <div className="tech-footer">
                    <span className="tutorial-count">
                      {tech.tutorialCount || 0} Tutorial{tech.tutorialCount !== 1 ? 's' : ''}
                    </span>
                    <span className="arrow">→</span>
                  </div>
                </div>
              ))}
            </div>
          )}

          {!loading && !error && technologies.length === 0 && (
            <div className="empty-state">
              <p>No technologies available at the moment.</p>
            </div>
          )}
        </div>
      </main>
      <Footer />
    </div>
  );
}

export default TutorialHome;

