package UIS.SATSA.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "notificaciones")
@Data
@AllArgsConstructor
public class Notificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer usuarioId;

    @Column(nullable = false, length = 150)
    private String usuarioEmail;

    @Column(nullable = false, length = 50)
    private String numeroSolicitud;

    @Column(nullable = false, length = 150)
    private String tipoSolicitud;

    @Column(nullable = false, length = 100)
    private String nuevoEstado;

    @Column(nullable = false)
    private LocalDate fecha;

    public Notificacion() {super();}

}
