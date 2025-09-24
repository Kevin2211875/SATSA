// src/types/index.ts
import type { ReactNode } from 'react';

// Tipos básicos
export type ButtonVariant = 'primary' | 'secondary' | 'outline' | 'danger';
export type ButtonSize = 'sm' | 'md' | 'lg';
export type CardVariant = 'default' | 'gray' | 'white' | 'warning';
export type NotificationType = 'success' | 'warning' | 'info' | 'error';
export type SolicitudState = 'borrador' | 'enviada' | 'en_revision' | 'aprobada' | 'rechazada' | 'completada';
export type PageType = 'login' | 'inicio' | 'cuenta' | 'crear' | 'notificaciones' | 'ayuda';

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

// Interfaces para datos de negocio
export interface User {
  id: string;
  firstName: string;
  lastName: string;
  email: string;
  username: string;
}

export interface Subject {
  id: number;
  name: string;
  professor: string;
  date: string;
  code: string;
  credits: number;
}

export interface UploadedFile {
  id: string | number;
  file: File;
  name: string;
  size: number;
  type: string;
  uploaded: boolean;
}

export interface SolicitudType {
  id: string;
  title: string;
  icon: ReactNode;
  description: string;
  disabled: boolean;
}

export interface HomeCard {
  id: string;
  title: string;
  description: string;
  icon: ReactNode;
  features: string[];
}

export interface Notification {
  id: number;
  title: string;
  message: string;
  type: NotificationType;
  date: string;
  read: boolean;
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

export interface FAQ {
  id: number;
  question: string;
  answer: string;
}

// Props para componentes específicos
export interface SidebarProps {
  currentPage: PageType;
  setCurrentPage: (page: PageType) => void;
}

export interface HeaderProps {
  currentPage: PageType;
}

export interface LayoutProps {
  children: ReactNode;
  currentPage: PageType;
  setCurrentPage: (page: PageType) => void;
}

export interface HomeCardProps extends Omit<HomeCard, 'id'> {
  onClick?: () => void;
}

export interface SolicitudTypeCardProps extends Omit<SolicitudType, 'icon'> {
  icon: ReactNode;
  onClick: (id: string) => void;
}

export interface LoginFormProps {
  onLogin: (userData: User) => void;
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
  onSelect: (subject: Subject) => void;
}

export interface SolicitudFormProps {
  solicitudType: SolicitudType;
  onSubmit: (formData: SolicitudFormData) => void;
  onBack: () => void;
  selectedSubject?: Subject | null;
  onOpenFormExam?: () => void;
}

// Tipos para páginas
export interface HomeProps {
  setCurrentPage: (page: PageType) => void;
}

export interface AccountProps {
  user?: User | null;
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
  user: User | null;
  notifications: Notification[];
}

// Tipos de eventos comunes
export type ChangeHandler = (e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement | HTMLSelectElement>) => void;
export type ClickHandler = (e: React.MouseEvent<HTMLButtonElement | HTMLDivElement>) => void;
export type SubmitHandler = (e: React.FormEvent<HTMLFormElement>) => void;