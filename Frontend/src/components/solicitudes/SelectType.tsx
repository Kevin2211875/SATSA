import React from 'react';
import SolicitudTypeCard from '../solicitudes/SolicitudTypeCard';
import type { SelectTypeProps } from '../../types';


const SelectType: React.FC<SelectTypeProps> = ({ tipos, onSelect }) => {
  return (
    <div className="bg-white p-6 rounded-2xl shadow-md w-[400px]">
      <div className="mb-6">
        <h3 className="text-lg font-semibold text-gray-700 mb-4">
          Selecciona el tipo de solicitud
        </h3>
      </div>

      <div className="grid grid-cols-1 md:grid-cols-2 gap-6">
        {tipos.map((type) => (
          <SolicitudTypeCard
            key={type.id}
            id={type.id.toString()}
            title={type.nombre}
            description={type.informacion}
            onClick={() => onSelect(type.id)}
          />
        ))}
      </div>
    </div>
  );
};

export default SelectType;
