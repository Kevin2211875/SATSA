// src/components/layout/Sidebar.tsx
import React from "react";
import { FileText, User, Plus, Bell, HelpCircle } from "lucide-react";
import type { SidebarProps, PageType } from "../../types";

interface MenuItem {
  id: PageType;
  label: string;
  icon: any;
}


const Sidebar: React.FC<SidebarProps> = ({ currentPage, setCurrentPage, expanded, setExpanded }) => {


  const menuItems: MenuItem[] = [
    { id: "inicio", label: "Inicio", icon: FileText },
    { id: "cuenta", label: "Cuenta", icon: User },
    { id: "crear", label: "Crear solicitud", icon: Plus },
    { id: "notificaciones", label: "Notificaciones", icon: Bell },
    { id: "ayuda", label: "Ayuda", icon: HelpCircle },
  ];

  return (
    <nav
      className={`bg-app-primary text-white h-full ${expanded ? "w-70" : "w-24"} flex flex-col py-6 p-4 transition-all duration-200 rounded-[10px]`}
      onMouseEnter={() => setExpanded(true)}
      onMouseLeave={() => setExpanded(false)}
    >
      {/* LOGO */}
      <div className="flex items-center justify-center mb-8 px-3 space-x-4">
        <img
          src="/src/assets/logoEISI.png"
          alt="Logo"
          className="rounded-lg p-1 "
        />
        {expanded && <span className="justify-start text-white text-4xl font-normal font-['Roboto'] text-shadow text-stroke">SATSA</span>}
      </div>

      {/* MENU */}
      <div className={`flex flex-col flex-1 space-y-2 justify-start gap-5 ${expanded ? "items-start px-4" : "items-center"
        }`}>
        {menuItems.map((item) => {
          const Icon = item.icon;
          const isActive = currentPage === item.id;

          return (
            <button
              key={item.id}
              onClick={() => setCurrentPage(item.id)}
              className={`flex items-center px-4 py-2 rounded-lg transition-colors
                ${isActive ? "bg-blue-700 text-white " : "text-blue-200 hover:bg-blue-800 hover:text-white"}
                ${expanded ? "w-full justify-start" : "w-auto justify-center"}
              `}
            >
              <Icon size={20} />
              {expanded && <span className="ml-3">{item.label}</span>}
            </button>
          );
        })}
      </div>
    </nav>
  );
};

export default Sidebar;
