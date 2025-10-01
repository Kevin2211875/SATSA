// src/App.jsx
import React, { useState } from 'react';
import Layout from './components/layout/Layout';
import Home from './pages/Home';
import CreateSolicitud from './pages/CreateSolicitud';
// import Account from './pages/Account';
// import Notifications from './pages/Notifications';
// import Help from './pages/Help';
import LoginForm from './components/auth/LoginForm';

function App() {
  const [currentPage, setCurrentPage] = useState('login');
  const [user, setUser] = useState(null);

  const handleLogin = (userData: any) => {
    setUser(userData);
    setCurrentPage('inicio');
  };

  const handleLogout = () => {
    setUser(null);
    setCurrentPage('login');
  };

  const renderPage = () => {
    switch (currentPage) {
      case 'inicio':
        return <Home setCurrentPage={setCurrentPage} />;
      case 'crear':
        return <CreateSolicitud />;
      // case 'cuenta':
      //   return <Account user={user} />;
      // case 'notificaciones':
      //   return <Notifications />;
      // case 'ayuda':
      //   return <Help />;
      default:
        return <Home setCurrentPage={setCurrentPage} />;
    }
  };

  if (currentPage === 'login') {
    return <LoginForm onLogin={handleLogin} />;
  }

  return (
    <Layout currentPage={currentPage} setCurrentPage={setCurrentPage}>
      {renderPage()}
    </Layout>
    
  );
}

export default App;