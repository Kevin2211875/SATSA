import React from 'react';
import type { FormularioProps } from '../../types';
import axios from 'axios';

const Form: React.FC<FormularioProps> = ({ tipo, onBack }) => {
  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();

    const formData = new FormData(e.target as HTMLFormElement);
    const data: Record<string, any> = {};

    // Convertir FormData a objeto normal
    formData.forEach((value, key) => {
      data[key] = value;
    });

    // Armar el payload completo
    const solicitudPayload = {
      tipoSolicitudId: tipo.id,
      campos: data
    };

    console.log("📤 Enviando solicitud:", solicitudPayload);

    try {
      const response = await axios.post(
        "http://localhost:8080/solicitudes/crear",
        solicitudPayload
      );

      console.log("✅ Solicitud creada:", response.data);
      alert("Solicitud enviada con éxito!");
    } catch (error) {
      console.error("❌ Error al enviar solicitud:", error);
      alert("Hubo un error al enviar la solicitud");
    }
  };

  return (
    <div className="bg-white p-6 rounded-2xl shadow-md min-h-0 h-full flex flex-col">
      <h3 className="text-xl font-semibold text-gray-700 mb-6">
        Formulario: {tipo.nombre}
      </h3>

      <form className="flex-1 min-h-0 overflow-y-auto space-y-4 pr-2 pb-10" onSubmit={handleSubmit}>
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

        <div className="flex justify-between mt-6 pb-4">
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

