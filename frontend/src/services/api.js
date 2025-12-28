import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080';
const AUTH_API_URL = `${API_BASE_URL}/api/auth`;
const TUTORIAL_API_URL = `${API_BASE_URL}/api/tutorials`;

const api = axios.create({
  baseURL: AUTH_API_URL,
  headers: {
    'Content-Type': 'application/json',
  },
});

const tutorialApi = axios.create({
  baseURL: TUTORIAL_API_URL,
  headers: {
    'Content-Type': 'application/json',
  },
});

export const signUp = async (username, email, password, role) => {
  try {
    const response = await api.post('/signup', {
      username,
      email,
      password,
      role: role || 'USER',
    });
    return response.data;
  } catch (error) {
    throw error.response?.data || { error: 'An error occurred during sign up' };
  }
};

export const signIn = async (username, password) => {
  try {
    const response = await api.post('/signin', {
      username,
      password,
    });
    return response.data;
  } catch (error) {
    throw error.response?.data || { error: 'An error occurred during sign in' };
  }
};

export const getTechnologies = async () => {
  try {
    const response = await tutorialApi.get('/technologies');
    return response.data;
  } catch (error) {
    throw error.response?.data || { error: 'Failed to fetch technologies' };
  }
};

export const getTechnologyById = async (id) => {
  try {
    const response = await tutorialApi.get(`/technologies/${id}`);
    return response.data;
  } catch (error) {
    throw error.response?.data || { error: 'Failed to fetch technology' };
  }
};

export default api;

