package UIS.SATSA.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "estado_solicitud")
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

    public EstadoSolicitud(Integer id, String estadoSolicitud, String descripcion) {
        this.id = id;
        this.estadoSolicitud = estadoSolicitud;
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEstadoSolicitud() {
        return estadoSolicitud;
    }

    public void setEstadoSolicitud(String estadoSolicitud) {
        this.estadoSolicitud = estadoSolicitud;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
