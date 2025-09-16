package UIS.SATSA.Model;

import jakarta.persistence.*;
import java.util.List;

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

    @OneToMany(mappedBy = "tipoSolicitud", cascade = CascadeType.ALL)
    private List<CampoSolicitud> campos;

    public TipoSolicitud() {super();}

    public TipoSolicitud(Integer id, String descripcion, String tipoSolicitud, List<CampoSolicitud> campos) {
        this.id = id;
        this.descripcion = descripcion;
        this.tipoSolicitud = tipoSolicitud;
        this.campos = campos;
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

    public List<CampoSolicitud> getCampos() {
        return campos;
    }

    public void setCampos(List<CampoSolicitud> campos) {
        this.campos = campos;
    }
}
