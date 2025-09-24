// src/pages/CreateSolicitud.tsx
import React from 'react';
import Card from '../components/common/Card';
import SolicitudTypeCard from '../components/solicitudes/SolicitudTypeCard';
import { SOLICITUD_TYPES } from '../utils/constants';

const CreateSolicitud: React.FC = () => {
  const handleSolicitudClick = (solicitudId: string) => {
    console.log('Solicitud seleccionada:', solicitudId);
    // Aquí puedes agregar la lógica para manejar la selección
  };

  return (
    <div className="max-w-6xl mx-auto">
      {/* Warning Banner */}
      <Card variant="warning" hover={false} className="mb-8">
        <div className="flex items-center">
          <span className="text-red-600 mr-2">⚠️</span>
          <span className="text-red-700 text-sm">
            No hay ningún programa activo para solicitud de becas en este momento.
          </span>
        </div>
      </Card>

      <h2 className="text-2xl font-bold text-gray-800 mb-8">Crear solicitudes</h2>
      
      <div className="mb-6">
        <h3 className="text-lg font-semibold text-gray-700 mb-4">
          Selecciona el tipo de solicitud
        </h3>
      </div>

      <div className="grid grid-cols-1 md:grid-cols-2 gap-6">
        {SOLICITUD_TYPES.map((type) => (
          <SolicitudTypeCard
            key={type.id}
            id={type.id}
            title={type.title}
            description={type.description}
            icon={type.icon}
            disabled={type.disabled}
            onClick={handleSolicitudClick}
          />
        ))}
      </div>
    </div>
  );
};

export default CreateSolicitud;
