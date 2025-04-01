import React from 'react';
import { createRoot } from 'react-dom/client';
import { Provider } from 'react-redux';
import JobList from './JobList';
import './index.css';

const container = document.getElementById('root');
const root = createRoot(container);

root.render(
  <React.StrictMode>
    <JobList />
  </React.StrictMode>
);
