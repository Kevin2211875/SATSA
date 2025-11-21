import React, { useEffect, useState } from 'react';
import AlertBanner from '../components/common/AlertBanner';
import SelectType from '../components/solicitudes/SelectType';
import Informacion from '../components/solicitudes/Information';
import Formulario from '../components/solicitudes/Form';
import axios from 'axios';
import type { TipoSolicitud } from '../types';

const CreateSolicitud: React.FC = () => {
  const [step, setStep] = useState(1);
  const [tipos, setTipos] = useState<TipoSolicitud[]>([]);
  const [tipoSeleccionado, setTipoSeleccionado] = useState<TipoSolicitud | null>(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState<string | null>(null);

  // 🔹 Obtener todos los tipos de solicitud desde el backend
  useEffect(() => {
    const fetchTipos = async () => {
      try {
        // ✅ Axios ya lanza error si el status no es 2xx
        const response = await axios.get<TipoSolicitud[]>('http://localhost:8080/tiposolicitud/listar');
        setTipos(response.data);
        console.log(response.data[0].campos);
      } catch (err) {
        console.error('Error al obtener tipos de solicitud:', err);
        setError('No se pudieron cargar los tipos de solicitud');
      } finally {
        setLoading(false);
      }
    };

    fetchTipos();
  }, []);

  const handleSelectType = (id: number) => {
    const seleccionado = tipos.find((t) => t.id === id) || null;
    setTipoSeleccionado(seleccionado);
    setStep(2);
  };

  const handleNext = () => setStep((prev) => prev + 1);
  const handleBack = () => setStep((prev) => prev - 1);

  if (loading) {
    return <p className="text-center text-gray-600 mt-8">Cargando tipos de solicitud...</p>;
  }

  if (error) {
    return <p className="text-center text-red-500 mt-8">{error}</p>;
  }

  return (
    <div className="max-w-6xl mx-auto h-screen overflow-hidden flex flex-col">
      <AlertBanner
        message="Para que su solicitud sea gestionada con éxito, también debe hacerlo por el módulo de estudiantes."
        type="error"
        duration={8000}
      />

      <h2 className="text-2xl font-bold text-gray-800 mb-8">Crear solicitudes</h2>

      {step === 1 && <SelectType tipos={tipos} onSelect={handleSelectType} />}
      {step === 2 && tipoSeleccionado && (
        <Informacion
          tipo={tipoSeleccionado}
          onNext={handleNext}
          onBack={handleBack}
        />
      )}
      {step === 3 && tipoSeleccionado && (
        <Formulario
          tipo={tipoSeleccionado}
          onBack={handleBack}
        />
      )}
    </div>
  );
};

export default CreateSolicitud;
