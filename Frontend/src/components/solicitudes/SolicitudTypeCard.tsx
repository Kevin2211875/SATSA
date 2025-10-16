// src/components/solicitudes/SolicitudTypeCard.tsx
import React from 'react';
import Card from '../common/Card';
import type { SolicitudTypeCardProps } from '../../types';

const SolicitudTypeCard: React.FC<SolicitudTypeCardProps> = ({ 
  id, 
  title, 
  description, 
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
