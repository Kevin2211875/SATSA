// src/types/index.ts
import type { ReactNode } from 'react';

// Tipos básicos
export type ButtonVariant = 'primary' | 'secondary' | 'outline' | 'danger';
export type ButtonSize = 'sm' | 'md' | 'lg';
export type CardVariant = 'default' | 'gray' | 'white' | 'warning';
export type NotificationType = 'success' | 'warning' | 'info' | 'error';
export type SolicitudState = 'enviada' | 'en_revision' | 'aprobada' | 'rechazada' | 'en_verificacion_externa';
export type PageType = 'login' | 'inicio' | 'cuenta' | 'crear' | 'notificaciones' | 'ver-solicitud' | 'paso-a-paso';

// Interfaces para componentes
export interface ButtonProps {
  children: ReactNode;
  onClick?: (e: React.MouseEvent<HTMLButtonElement>) => void;
  variant?: ButtonVariant;
  size?: ButtonSize;
  disabled?: boolean;
  icon?: ReactNode;
  className?: string;
  type?: 'button' | 'submit' | 'reset';
  as?: 'button' | 'span';
}

export interface CardProps {
  children: ReactNode;
  title?: string;
  icon?: ReactNode;
  onClick?: () => void;
  className?: string;
  variant?: CardVariant;
  hover?: boolean;
}

export interface InputProps {
  label?: string;
  type?: string;
  placeholder?: string;
  value?: string;
  onChange?: (e: React.ChangeEvent<HTMLInputElement>) => void;
  error?: string;
  required?: boolean;
  disabled?: boolean;
  className?: string;
}

export interface SelectTypeProps {
  tipos: TipoSolicitud[];
  onSelect: (id: number) => void;
}

export interface FormularioProps {
  tipo: TipoSolicitud;
  onBack: () => void;
}

export interface InformationProps {
  tipo: TipoSolicitud;
  onNext: () => void;
  onBack: () => void;
}

// Interfaces de las tablas de la base de datos
export interface Asignatura {
  id: number;
  codigo: string;
  nombre: string;
}

export interface Profesor {
  id: number;
  apellidos: string;
  correo: string;
  nombres: string;
}

export interface ProgramaAcademico {
  id: number;
  codigo_programa: string;
  nombre: string;
}

export interface Rol {
  id: number;
  rol_nombre: string;
}

export interface EstadoSolicitud {
  id: number;
  descripcion: string;
  estado_solicitud: string;
}

// --- Entidades relacionadas ---

export interface Usuario {
  id: number;
  apellidos: string;
  codigo: string;
  contrasena: string;
  cuenta_activa: boolean;
  correo: string;
  nombres: string;
  telefono: string;
  id_programa: number;
  programa?: ProgramaAcademico;
}

export interface UsuarioRol {
  id: number;
  rol_activo: boolean;
  id_rol: number;
  id_usuario: number;
  rol?: Rol;
  usuario?: Usuario;
}

export interface Grupo {
  id: number;
  codigo: string;
  id_asignatura: number;
  id_profesor: number;
  asignatura?: Asignatura;
  profesor?: Profesor;
}

export interface Solicitud {
  id: number;
  campos: Record<string, any>;
  detalle: string;
  fecha_solicitud: string; // timestamp sin zona horaria → string ISO
  numero_solicitud: string;
  id_estado: number;
  tipo_solicitud_id: number;
  id_usuario: number;

  estado?: EstadoSolicitud;
  tipoSolicitud?: TipoSolicitud;
  usuario?: Usuario;
}

export interface Documentos {
  id: number;
  fecha: string; // date → string ISO
  fecha_modificacion?: string | null;
  nombre: string;
  ruta_documento: string;
  id_solicitud: number;
  solicitud?: Solicitud;
}

export interface Historial {
  id: number;
  comentario?: string;
  fecha: string;
  estado_anterior?: number | null;
  estado_nuevo?: number | null;
  id_solicitud: number;
  id_usuario: number;

  estadoAnterior?: EstadoSolicitud;
  estadoNuevo?: EstadoSolicitud;
  solicitud?: Solicitud;
  usuario?: Usuario;
}

export interface Notificacion {
  id: number;
  fecha: string;
  nuevo_estado: string;
  numero_solicitud: string;
  tipo_solicitud: string;
  usuario_email: string;
  usuario_id: number;
}

export interface Token {
  id: number;
  is_expired: boolean;
  is_revoked: boolean;
  token: string;
  token_type: 'BEARER';
  id_usuario: number;
  usuario?: Usuario;
}


export interface UploadedFile {
  id: string | number;
  file: File;
  name: string;
  size: number;
  type: string;
  uploaded: boolean;
}

export interface TipoSolicitud {
  id: number;
  nombre: string;
  informacion: string;
  disabled: boolean;
  campos: Record<string, any>;
}

export interface HomeCard {
  id: string;
  title: string;
  description: string;
  icon: ReactNode;
  features: string[];
}

export interface Step {
  title: string;
  description?: string;
}

export interface SolicitudFormData {
  nombreSolicitud: string;
  tipoAsignatura: string;
  fechaAsignatura: string;
  observaciones: string;
  documentos: UploadedFile[];
}

// Props para componentes específicos
export interface SidebarProps {
  currentPage: PageType;
  setCurrentPage: (page: PageType) => void;
  expanded: boolean;
  setExpanded: React.Dispatch<React.SetStateAction<boolean>>;
  className?: string;
}

export interface HeaderProps {
  currentPage: PageType;
}

export interface LayoutProps {
  currentPage: PageType;
  setCurrentPage: (page: PageType) => void;
  children: React.ReactNode;
}

export interface  CreateSolicitudProps {
  children: React.ReactNode;
}
export interface HomeCardProps extends Omit<HomeCard, 'id'> {
  onClick?: () => void;
}

export interface SolicitudTypeCardProps {
  id: string;
  title: string;
  description: string;
  onClick: (id: string) => void;
  disabled?: boolean;
}

export interface LoginFormProps {
  onLogin: (userData: Usuario) => void;
}

export interface DatePickerProps {
  value?: string;
  onChange?: (date: string) => void;
  placeholder?: string;
  disabled?: boolean;
}

export interface StepsIndicatorProps {
  steps: Step[];
  currentStep: number;
  onStepClick?: (step: number) => void;
  allowClickNavigation?: boolean;
}

export interface SimpleStepsIndicatorProps {
  totalSteps: number;
  currentStep: number;
  onStepClick?: (step: number) => void;
  allowClickNavigation?: boolean;
}

export interface DocumentUploadProps {
  onUpload: (files: UploadedFile[]) => void;
  maxFiles?: number;
}

export interface FormExamProps {
  isOpen: boolean;
  onClose: () => void;
  onSelect: (subject: Asignatura) => void;
}

export interface SolicitudFormProps {
  solicitudType: TipoSolicitud;
  onSubmit: (formData: SolicitudFormData) => void;
  onBack: () => void;
  selectedSubject?: Asignatura | null;
  onOpenFormExam?: () => void;
}

// Tipos para páginas
export interface HomeProps {
  setCurrentPage: (page: PageType) => void;
}

export interface AccountProps {
  user?: Usuario | null;
}

export interface CreateSolicitudProps {
  setCurrentPage: (page: PageType) => void;
}

// Tipos para errores de formulario
export interface FormErrors {
  [key: string]: string;
}

// Tipos para estado de la aplicación
export interface AppState {
  currentPage: PageType;
  user: Usuario | null;
  notifications: Notification[];
}

// Tipos de eventos comunes
export type ChangeHandler = (e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement | HTMLSelectElement>) => void;
export type ClickHandler = (e: React.MouseEvent<HTMLButtonElement | HTMLDivElement>) => void;
export type SubmitHandler = (e: React.FormEvent<HTMLFormElement>) => void;