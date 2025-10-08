// src/components/common/Modal.tsx
import React from "react";

interface ModalProps {
  isOpen: boolean;
  onClose: () => void;
  title?: string;
  children: React.ReactNode;
}

const Modal: React.FC<ModalProps> = ({ isOpen, onClose, title, children }) => {
  if (!isOpen) return null;

  return (
    <div className="fixed inset-0 bg-black/40 flex justify-center items-center z-50">
      <div className="bg-white rounded-2xl shadow-xl w-full max-w-md p-6 relative animate-fadeIn">
        {/* Botón de cerrar */}
        <button
          onClick={onClose}
          className="absolute top-3 right-3 text-gray-500 hover:text-gray-800 text-xl"
          aria-label="Cerrar modal"
        >
          &times;
        </button>

        {/* Título */}
        {title && (
          <h2 className="text-lg font-semibold text-gray-800 mb-4">{title}</h2>
        )}

        {/* Contenido */}
        {children}
      </div>
    </div>
  );
};

export default Modal;
