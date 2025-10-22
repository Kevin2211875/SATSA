package UIS.SATSA.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tipo_solicitud")
@Getter
@Setter
public class TipoSolicitud {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(columnDefinition = "jsonb", nullable = false)
    private String campos;

    public TipoSolicitud() {super();}

    public TipoSolicitud(Integer id, String nombre, String campos) {
        this.id = id;
        this.nombre = nombre;
        this.campos = campos;
    }
}
