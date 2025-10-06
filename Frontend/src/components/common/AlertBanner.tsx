import React, { useState, useEffect } from "react";

interface AlertBannerProps {
  message: string;
  type?: "warning" | "error" | "success" | "info";
  duration?: number; // opcional, en milisegundos
}

const AlertBanner: React.FC<AlertBannerProps> = ({ message, type = "warning", duration }) => {
  const [visible, setVisible] = useState(true);

  // Si se pasa duration, se cierra automáticamente
  useEffect(() => {
    if (duration) {
      const timer = setTimeout(() => setVisible(false), duration);
      return () => clearTimeout(timer);
    }
  }, [duration]);

  if (!visible) return null;

  // Colores según el tipo de alerta
  const typeStyles: Record<string, string> = {
    warning: "bg-yellow-50 border-yellow-300 text-yellow-800",
    error: "bg-red-50 border-red-300 text-red-800",
    success: "bg-green-50 border-green-300 text-green-800",
    info: "bg-blue-50 border-blue-300 text-blue-800",
  };

  return (
    <div
      className={`fixed top-4 left-1/2 -translate-x-1/2 z-50 w-[90%] max-w-3xl border rounded-md shadow-lg p-4 flex items-center justify-between ${typeStyles[type]}`}
    >
      <span className="text-sm">{message}</span>
      <button
        onClick={() => setVisible(false)}
        className="ml-4 text-lg font-bold hover:opacity-70"
      >
        ✖
      </button>
    </div>
  );
};

export default AlertBanner;
