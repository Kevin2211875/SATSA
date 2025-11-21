import React, { useState } from 'react';
import Layout from './components/layout/Layout';
import Home from './pages/Home';
import CreateRequest from './pages/CreateRequest';
// import Account from './pages/Account';
// import Notifications from './pages/Notifications';
// import Help from './pages/Help';
import LoginForm from './components/auth/LoginForm';

import type { PageType } from './types'; // Make sure this import exists and is correct

function App() {
  const [currentPage, setCurrentPage] = useState<PageType>('inicio');
  const [user, setUser] = useState(null);

  const handleLogin = (userData: any) => {
    setUser(userData);
    setCurrentPage('crear');
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
        return <CreateRequest />;
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