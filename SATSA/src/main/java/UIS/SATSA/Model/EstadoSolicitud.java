package UIS.SATSA.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "estado_solicitud")
@Data
public class EstadoSolicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50)
    private String estadoSolicitud;

    @Column(nullable = false, length = 50)
    private String descripcion;

    public EstadoSolicitud() {super();}

    public EstadoSolicitud(Integer id) {
        this.id = id;
    }

}
