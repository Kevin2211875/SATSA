// src/components/layout/Sidebar.tsx
import React from 'react';
import { 
  FileText, 
  User, 
  Plus, 
  Bell, 
  HelpCircle 
} from 'lucide-react';

export interface SidebarProps {
  currentPage: string;
  setCurrentPage: (page: string) => void;
}

interface SidebarItemProps {
  item: { id: string; label: string; icon: React.ElementType };
  isActive: boolean;
  onClick: () => void;
}

const SidebarItem: React.FC<SidebarItemProps> = ({ item, isActive, onClick }) => {
  const Icon = item.icon;
  return (
    <button
      onClick={onClick}
      className={`w-12 h-12 rounded-lg mb-4 flex items-center justify-center transition-colors group relative ${
        isActive 
          ? 'bg-blue-700 text-white' 
          : 'text-blue-200 hover:bg-blue-800 hover:text-white'
      }`}
      title={item.label}
    >
      <Icon size={20} />
      {/* Tooltip */}
      <div className="absolute left-16 bg-gray-800 text-white px-2 py-1 rounded text-sm opacity-0 group-hover:opacity-100 transition-opacity whitespace-nowrap z-50">
        {item.label}
      </div>
    </button>
  );
};

const Sidebar: React.FC<SidebarProps> = ({ currentPage, setCurrentPage }) => {
  const menuItems = [
    { id: 'inicio', label: 'Inicio', icon: FileText },
    { id: 'cuenta', label: 'Cuenta', icon: User },
    { id: 'crear', label: 'Crear solicitud', icon: Plus },
    { id: 'notificaciones', label: 'Notificaciones', icon: Bell },
    { id: 'ayuda', label: 'Ayuda', icon: HelpCircle }
  ];

  return (
    <div className="bg-blue-900 text-white h-screen w-20 flex flex-col items-center py-6 fixed left-0 top-0 z-40">
      {/* Logo */}
      <div className="bg-white text-blue-900 rounded-lg p-3 mb-8">
        <FileText size={24} />
      </div>
      {/* Menu Items */}
      <nav className="flex flex-col">
        {menuItems.map((item) => (
          <SidebarItem
            key={item.id}
            item={item}
            isActive={currentPage === item.id}
            onClick={() => setCurrentPage(item.id)}
          />
        ))}
      </nav>
    </div>
  );
};

export default Sidebar;
