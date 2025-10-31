import React from 'react';
import type { FormularioProps} from '../../types';

const Form: React.FC<FormularioProps> = ({ tipo, onBack }) => {
  // Render dinámico según los campos JSON
  return (
    <div className="bg-white p-6 rounded-2xl shadow-md">
      <h3 className="text-xl font-semibold text-gray-700 mb-6">
        Formulario: {tipo.nombre}
      </h3>

      <form className="space-y-4">
        {Object.entries(tipo.campos).map(([campo, valor]) => (
          <div key={campo}>
            <label className="block text-sm font-medium text-gray-700 mb-1">
              {campo}
            </label>
            <input
              type="text"
              name={campo}
              defaultValue={valor}
              className="w-full border border-gray-300 rounded-lg px-3 py-2 focus:ring focus:ring-blue-200"
            />
          </div>
        ))}

        <div className="flex justify-between mt-6">
          <button
            type="button"
            onClick={onBack}
            className="px-4 py-2 bg-gray-300 text-gray-700 rounded-lg hover:bg-gray-400"
          >
            Atrás
          </button>
          <button
            type="submit"
            className="px-4 py-2 bg-green-600 text-white rounded-lg hover:bg-green-700"
          >
            Enviar solicitud
          </button>
        </div>
      </form>
    </div>
  );
};

export default Form;

