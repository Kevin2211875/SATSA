package Model;

import jakarta.persistence.*;

@Entity
@Table(name = "tipo_solicitud")
public class TipoSolicitud {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String descripcion;

    @Column(nullable = false, length = 100)
    private String tipoSolicitud;

    public TipoSolicitud() {super();}

    public TipoSolicitud(Integer id, String descripcion, String tipoSolicitud) {
        this.id = id;
        this.descripcion = descripcion;
        this.tipoSolicitud = tipoSolicitud;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoSolicitud() {
        return tipoSolicitud;
    }

    public void setTipoSolicitud(String tipoSolicitud) {
        this.tipoSolicitud = tipoSolicitud;
    }
}
