// src/pages/CreateSolicitud.tsx
import React from 'react';
import AlertBanner from '../components/common/AlertBanner';
import SolicitudTypeCard from '../components/solicitudes/SolicitudTypeCard';
import { SOLICITUD_TYPES } from '../utils/constants';

const CreateSolicitud: React.FC = () => {
  const handleSolicitudClick = (solicitudId: string) => {
    console.log('Solicitud seleccionada:', solicitudId);
    // Aquí puedes agregar la lógica para manejar la selección
  };

  return (
    <div className="max-w-6xl mx-auto">
      {/* Alerta de advertencia */}
      <AlertBanner 
        message="Para que su solicitud sea gestionada con éxito, también debe hacerlo por el módulo de estudiantes." 
        type="error"
        duration={8000} // opcional: se cierra en 8 segundos
      />

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
