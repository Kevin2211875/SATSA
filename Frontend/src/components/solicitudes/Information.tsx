import React from 'react';
import type { InformationProps } from '../../types';
const Information: React.FC<InformationProps> = ({ tipo, onNext, onBack }) => {
  return (
    <div className="bg-white p-6 rounded-2xl shadow-md">
      <h3 className="text-xl font-semibold text-gray-700 mb-4">
        Información sobre la solicitud: {tipo.nombre}
      </h3>
      <p className="text-gray-600 mb-6">{tipo.informacion}</p>

      <div className="flex justify-between">
        <button
          onClick={onBack}
          className="px-4 py-2 bg-gray-300 text-gray-700 rounded-lg hover:bg-gray-400"
        >
          Atrás
        </button>
        <button
          onClick={onNext}
          className="px-4 py-2 bg-blue-600 text-white rounded-lg hover:bg-blue-700"
        >
          Continuar
        </button>
      </div>
    </div>
  );
};

export default Information;
