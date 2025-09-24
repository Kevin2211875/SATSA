// src/components/layout/Layout.tsx
import React from 'react';
import Sidebar from './Sidebar';

export interface LayoutProps {
  children: React.ReactNode;
  currentPage: string;
  setCurrentPage: (page: string) => void;
}

const Layout: React.FC<LayoutProps> = ({ children, currentPage, setCurrentPage }) => {
  return (
    <div className="bg-gray-50 min-h-screen">
      <Sidebar currentPage={currentPage} setCurrentPage={setCurrentPage} />
      <main className="ml-20 p-8 bg-gray-50 min-h-screen">
        {children}
      </main>
    </div>
  );
};

export default Layout;
