// src/components/home/HomeCard.jsx
import React from 'react';
import Card from '../common/Card';

const HomeCard = ({ title, description, features, icon, onClick }) => {
  return (
    <Card 
      variant="gray" 
      hover={!!onClick}
      onClick={onClick}
      className="h-full"
    >
      <div className="flex items-center mb-4">
        {icon && <span className="mr-3 text-gray-600">{icon}</span>}
        <h3 className="text-lg font-semibold text-gray-800">{title}</h3>
      </div>
      
      <p className="text-gray-600 mb-4 text-sm">{description}</p>
      
      {features && features.length > 0 && (
        <ul className="text-sm text-gray-700 space-y-1">
          {features.map((feature, index) => (
            <li key={index}>• {feature}</li>
          ))}
        </ul>
      )}
    </Card>
  );
};

export default HomeCard;