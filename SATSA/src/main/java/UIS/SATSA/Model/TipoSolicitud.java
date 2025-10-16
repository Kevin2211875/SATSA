package UIS.SATSA.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tipo_solicitud")
@Data
public class TipoSolicitud {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 2500)
    private String informacion;

    @Column(nullable = false)
    private boolean disabled;

    @Column(columnDefinition = "jsonb", nullable = false)
    private String campos;

    public TipoSolicitud() {super();}

}
