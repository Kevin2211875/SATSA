package UIS.SATSA.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "historial")
@Data
public class Historial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "TEXT")
    private String comentario; // descripción del cambio (opcional, puede ser null)

    @Column(nullable = false)
    private LocalDate fecha; // mejor usar LocalDateTime que Date

    @ManyToOne
    @JoinColumn(name = "id_solicitud", nullable = false)
    private Solicitud solicitud;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario; // quien hizo el cambio

    @ManyToOne
    @JoinColumn(name = "estado_anterior")
    private EstadoSolicitud estadoAnterior;

    @ManyToOne
    @JoinColumn(name = "estado_nuevo")
    private EstadoSolicitud estadoNuevo;

}
