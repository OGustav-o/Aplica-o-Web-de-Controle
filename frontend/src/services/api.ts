import axios from 'axios';

const api = axios.create({
  baseURL: '/api', // Nginx no container redireciona para backend
});

export default api;
