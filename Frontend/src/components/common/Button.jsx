/ src/components/common/Button.jsx
import React from 'react';

const Button = ({ 
  children, 
  onClick, 
  variant = 'primary', 
  size = 'md', 
  disabled = false, 
  icon, 
  className = '',
  ...props 
}) => {
  const baseClasses = 'font-medium rounded-lg transition-colors flex items-center justify-center focus:outline-none focus:ring-2 focus:ring-offset-2';
  
  const variants = {
    primary: 'bg-blue-900 text-white hover:bg-blue-800 focus:ring-blue-500 disabled:bg-blue-300',
    secondary: 'bg-gray-800 text-white hover:bg-gray-700 focus:ring-gray-500 disabled:bg-gray-300',
    outline: 'border-2 border-blue-900 text-blue-900 hover:bg-blue-900 hover:text-white focus:ring-blue-500',
    danger: 'bg-red-600 text-white hover:bg-red-700 focus:ring-red-500 disabled:bg-red-300'
  };
  
  const sizes = {
    sm: 'px-3 py-2 text-sm',
    md: 'px-4 py-3 text-base',
    lg: 'px-6 py-4 text-lg'
  };
  
  const classes = `${baseClasses} ${variants[variant]} ${sizes[size]} ${className}`;
  
  return (
    <button 
      onClick={onClick} 
      disabled={disabled}
      className={classes}
      {...props}
    >
      {icon && <span className="mr-2">{icon}</span>}
      {children}
    </button>
  );
};

export default Button;