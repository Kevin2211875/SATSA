// src/pages/Home.tsx
import React from 'react';
import HomeCard from '../components/home/HomeCard';
import { HOME_CARDS, PASO_A_PASO_CARD } from '../utils/constants';

import type { PageType } from '../types';
export interface HomeProps {
  setCurrentPage: (page: PageType) => void;
}

const Home: React.FC<HomeProps> = ({ setCurrentPage }) => {
  const handleCardClick = (cardId: string) => {
    if (cardId === 'crear-solicitudes') {
      setCurrentPage('crear');
    }
    // Agregar más navegación según sea necesario
  };

  return (
    <div className="min-h-screen flex flex-col">
      {/* Contenido principal */}
      <div className="flex-grow flex flex-col">
        {/* Título */}
        <div className="max-w-6xl mx-auto w-full px-6 pt-8">
          <h2 className="text-2xl font-bold text-gray-800 mb-8 border-b-2 border-blue-600 pb-2">
            Inicio
          </h2>
        </div>

        {/* Contenedor centrado */}
        <div className="flex-1 flex justify-center items-center px-6 pb-8">
          <div className="flex flex-col justify-center items-center gap-10 space-y-[10%]">
            {/* Tarjetas principales */}
            <div className="grid grid-cols-1 md:grid-cols-2 gap-8">
              {HOME_CARDS.map((card) => (
                <HomeCard
                  key={card.id}
                  title={card.title}
                  description={card.description}
                  features={card.features}
                  icon={card.icon}
                  onClick={() => handleCardClick(card.id)}
                />
              ))}
            </div>

            {/* Tarjeta inferior */}
            <div>
              <HomeCard
                title={PASO_A_PASO_CARD.title}
                description={PASO_A_PASO_CARD.description}
                features={PASO_A_PASO_CARD.features}
                icon={PASO_A_PASO_CARD.icon}
              />
            </div>
          </div>
        </div>
      </div>
    </div>

  );
};

export default Home;
