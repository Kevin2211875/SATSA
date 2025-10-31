// src/components/common/Button.tsx
import React from 'react';
import type { ButtonProps, ButtonVariant, ButtonSize } from '../../types';

const Button: React.FC<ButtonProps> = ({ 
  children, 
  onClick, 
  variant = 'primary', 
  size = 'md', 
  disabled = false, 
  icon, 
  className = '',
  type = 'button',
  as = 'button',
  ...props 
}) => {
  const baseClasses = 'font-medium rounded-lg transition-colors flex items-center justify-center focus:outline-none focus:ring-2 focus:ring-offset-2';
  
  const variants: Record<ButtonVariant, string> = {
    primary: 'bg-blue-900 text-white hover:bg-blue-800 focus:ring-blue-500 disabled:bg-blue-300',
    secondary: 'bg-gray-800 text-white hover:bg-gray-700 focus:ring-gray-500 disabled:bg-gray-300',
    outline: 'border-2 border-blue-900 text-blue-900 hover:bg-blue-900 hover:text-white focus:ring-blue-500',
    danger: 'bg-red-600 text-white hover:bg-red-700 focus:ring-red-500 disabled:bg-red-300'
  };
  
  const sizes: Record<ButtonSize, string> = {
    sm: 'px-3 py-2 text-sm',
    md: 'px-4 py-3 text-base',
    lg: 'px-6 py-4 text-lg'
  };
  
  const classes = `${baseClasses} ${variants[variant]} ${sizes[size]} ${className}`;
  
  const commonProps = {
    disabled,
    className: classes,
    ...props
  };

  if (as === 'span') {
    return (
      <span {...commonProps}>
        {icon && <span className="mr-2">{icon}</span>}
        {children}
      </span>
    );
  }
  
  return (
    <button 
      type={type}
      onClick={onClick} 
      {...commonProps}
    >
      {icon && <span className="mr-2">{icon}</span>}
      {children}
    </button>
  );
};

export default Button;