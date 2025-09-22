// src/components/layout/Layout.jsx
import React from 'react';
import Sidebar from './Sidebar';
import Header from './Header';

const Layout = ({ children, currentPage, setCurrentPage }) => {
  return (
    <div className="bg-gray-50 min-h-screen">
      <Sidebar currentPage={currentPage} setCurrentPage={setCurrentPage} />
      <Header currentPage={currentPage} />
      <main className="ml-20 p-8 bg-gray-50 min-h-screen">
        {children}
      </main>
    </div>
  );
};

export default Layout;