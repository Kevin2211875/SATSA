// src/components/solicitudes/SolicitudTypeCard.jsx
import React from 'react';
import Card from '../common/Card';

const SolicitudTypeCard = ({ 
  id, 
  title, 
  description, 
  icon, 
  onClick,
  disabled = false 
}) => {
  return (
    <Card 
      onClick={!disabled ? () => onClick(id) : undefined}
      hover={!disabled}
      className={`h-full ${disabled ? 'opacity-50 cursor-not-allowed' : ''}`}
    >
      <div className="flex flex-col items-center text-center">
        <div className="mb-4">
          {icon}
        </div>
        <h4 className="text-sm font-semibold text-gray-800 mb-2 leading-tight">
          {title}
        </h4>
        <p className="text-xs text-gray-600">
          {description}
        </p>
        {disabled && (
          <div className="mt-3 px-3 py-1 bg-red-100 text-red-700 rounded-full text-xs">
            No disponible
          </div>
        )}
      </div>
    </Card>
  );
};

export default SolicitudTypeCard;