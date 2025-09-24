// src/components/common/Card.tsx
import React from 'react';
import type { CardProps, CardVariant } from '../../types';

const Card: React.FC<CardProps> = ({ 
  children, 
  title, 
  icon, 
  onClick, 
  className = '',
  variant = 'default',
  hover = true 
}) => {
  const baseClasses = 'rounded-lg p-6 transition-all';
  
  const variants: Record<CardVariant, string> = {
    default: 'bg-white border border-gray-200 shadow-sm',
    gray: 'bg-gray-200',
    white: 'bg-white shadow-lg',
    warning: 'bg-red-100 border border-red-300'
  };
  
  const hoverClasses = hover ? 'hover:shadow-lg hover:border-blue-300 cursor-pointer' : '';
  const clickable = onClick ? 'cursor-pointer' : '';
  
  const classes = `${baseClasses} ${variants[variant]} ${hoverClasses} ${clickable} ${className}`;
  
  const handleClick = () => {
    if (onClick) {
      onClick();
    }
  };

  const handleKeyDown = (e: React.KeyboardEvent) => {
    if (onClick && (e.key === 'Enter' || e.key === ' ')) {
      e.preventDefault();
      onClick();
    }
  };
  
  return (
    <div 
      className={classes} 
      onClick={handleClick}
      onKeyDown={handleKeyDown}
      tabIndex={onClick ? 0 : undefined}
      role={onClick ? 'button' : undefined}
    >
      {(title || icon) && (
        <div className="flex items-center mb-4">
          {icon && <span className="mr-3">{icon}</span>}
          {title && <h3 className="text-lg font-semibold text-gray-800">{title}</h3>}
        </div>
      )}
      {children}
    </div>
  );
};

export default Card;
