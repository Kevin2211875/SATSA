// src/utils/constants.ts
import React from 'react';
import {
  FileCheck,
  BookOpen,
  Upload,
  Calendar,
  Menu,
  PlusCircle
} from 'lucide-react';
import type { SolicitudType, HomeCard, Step, NotificationType, SolicitudState } from '../types';

export const SOLICITUD_TYPES: SolicitudType[] = [
  {
    id: 'supletorios',
    title: 'VALIDACIÓN MEDICA PARA SUPLETORIOS INTRASEMESTRALES O EXCUSAS',
    icon: React.createElement(FileCheck, { className: "w-12 h-12 text-blue-600" }),
    description: 'Validación médica para supletorios intrasemestrales o excusas',
    disabled: false
  },
  {
    id: 'homologacion-intercambio',
    title: 'HOMOLOGACIÓN DE ASIGNATURAS CURSADAS EN INTERCAMBIO ACADÉMICO',
    icon: React.createElement(BookOpen, { className: "w-12 h-12 text-green-600" }),
    description: 'Homologar materias cursadas en otras instituciones durante intercambio académico',
    disabled: true
  },
  {
    id: 'ampliacion-permanencia',
    title: 'AMPLIACIÓN DEL PERIODO DE PERMANENCIA',
    icon: React.createElement(Upload, { className: "w-12 h-12 text-purple-600" }),
    description: 'Solicitar ampliación del periodo de permanencia académica',
    disabled: true
  },
  {
    id: 'readmision-pregrado',
    title: 'READMISIÓN DE ESTUDIANTES DE PREGRADO DENTRO DE LAS FECHAS ESTABLECIDAS EN EL CALENDARIO ACADÉMICO',
    icon: React.createElement(Calendar, { className: "w-12 h-12 text-orange-600" }),
    description: 'Readmisión de estudiantes de pregrado dentro de las fechas establecidas en el calendario académico',
    disabled: true
  }
];

export const HOME_CARDS: HomeCard[] = [
  {
    id: 'ver-solicitudes',
    title: 'Ver Solicitudes',
    description: 'Consulta el estado de tus solicitudes realizadas.',
    icon: React.createElement(Menu, { className: "text-gray-600", size: 24 }),
    features: [
      'Revisar solicitudes enviadas.',
      'Consultar el estado.',
      'Cargar documentos.'
    ]
  },
  {
    id: 'crear-solicitudes',
    title: 'Crear solicitudes',
    description: 'Registra nuevas solicitudes según tu necesidad académica.',
    icon: React.createElement(PlusCircle, { className: "text-gray-600", size: 24 }),
    features: [
      'Crear una nueva solicitud.',
      'Especificar detalles y observaciones.',
      'Adjuntar documentos de soporte.'
    ]
  },
  {
    id: 'paso-a-paso',
    title: 'Paso a paso',
    description: 'Visualiza las instrucciones de cómo crear tu solicitud',
    icon: React.createElement(Menu, { className: "text-gray-600", size: 24 }),
    features: [
      'Acceder a una guía interactiva.',
      'Seguir las instrucciones para diligenciar su solicitud.',
      'Conocer los documentos necesarios para cada trámite.'
    ]
  }
];

export const PASO_A_PASO_CARD: Omit<HomeCard, 'id'> = {
  title: 'Paso a paso',
  description: 'Visualiza las instrucciones de cómo crear tu solicitud',
  icon: React.createElement(Menu, { className: "text-gray-600", size: 24 }),
  features: [
    'Acceder a una guía interactiva.',
    'Seguir las instrucciones para diligenciar su solicitud.',
    'Conocer los documentos necesarios para cada trámite.'
  ]
};

// Pasos para el formulario de solicitudes
export const SOLICITUD_STEPS: Step[] = [
  {
    title: 'Información',
    description: 'Datos básicos'
  },
  {
    title: 'Detalles',
    description: 'Información legal'
  },
  {
    title: 'Documentos',
    description: 'Archivos requeridos'
  }
];

// Tipos de notificaciones
export const NOTIFICATION_TYPES: Record<string, NotificationType> = {
  SUCCESS: 'success',
  WARNING: 'warning',
  INFO: 'info',
  ERROR: 'error'
} as const;

// Estados de solicitudes
export const SOLICITUD_STATES: Record<string, SolicitudState> = {
  ENVIADA: 'enviada',
  EN_REVISION: 'en_revision',
  APROBADA: 'aprobada',
  RECHAZADA: 'rechazada',
} as const;

// Textos legales por tipo de solicitud
export const ARTICULO_TEXTS: Record<string, string> = {
  'validacion-medica': `ARTÍCULO 284°: Modificado por el Acuerdo del Consejo Superior N° 090 de noviembre 15 de 2022.
Aquellos(as) estudiantes que teniendo(as) a su disposición el solicitante según prescriba en la legislación vigente pertinente
y los recursos económicos suficientes para los gastos de diligenciamiento de derechos acogidos por reglamento específico...

El Decano de la Escuela o su Departamento o la IES debe supervisar el mantenimiento durante los dos días dos días
hábiles siguientes o la fecha de matricula del examen solicitado, al titular de estudiantes participantes para garantizar
que su estado de salud sea compatible con las actividades académicas y extracurriculares que desarrollará.

El estudiante que haya obtenido esta autorización deberá mantener el certificado médico actualizado durante el período
para poder la asistencia de clases(s).

La Escuela o Departamento que otorgue la asignatura, una vez concedida la beca deberá ser establecida en procesos de matricula al
estudiante beneficiario, el estudiante beneficiado considerará terminadas anteriores.

PARÁGRAFO 1°: Los estudiantes que opten Solicited Authorized para representar a la Universidad en eventos
deportivos, culturales o deportivos, deberán reportar a eventos especiales y no podrán el Estudiante las actividades
académicas normales del período. Para ello deberán utilizar los beneficios a que pueden acceder Decanos interesados deben informar oportunamente al Registro...`
};

// Configuración de archivos permitidos
export const FILE_CONFIG = {
  ALLOWED_TYPES: ['application/pdf', 'image/jpeg', 'image/png', 'application/msword', 'application/vnd.openxmlformats-officedocument.wordprocessingml.document'],
  MAX_SIZE: 10 * 1024 * 1024, // 10MB
  MAX_FILES: 5
} as const;

// Mensajes de validación
export const VALIDATION_MESSAGES = {
  REQUIRED: 'Este campo es requerido',
  EMAIL_INVALID: 'El email no es válido',
  FILE_TOO_LARGE: 'Archivo muy grande. Máximo 10MB',
  FILE_TYPE_INVALID: 'Tipo de archivo no válido',
  MAX_FILES_EXCEEDED: 'Solo puedes subir un máximo de 5 archivos'
} as const;