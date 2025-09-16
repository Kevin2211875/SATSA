package UIS.SATSA.Model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "solicitud")
public class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String detalle;

    @Column(nullable = false)
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "id_tipoSolicitud")
    private TipoSolicitud tipoSolicitud;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_estado")
    private EstadoSolicitud estado;

    public Solicitud() {super();}

    public Solicitud(Integer id, String detalle, Date fecha, TipoSolicitud tipoSolicitud, Usuario usuario, EstadoSolicitud estado) {
        this.id = id;
        this.detalle = detalle;
        this.fecha = fecha;
        this.tipoSolicitud = tipoSolicitud;
        this.usuario = usuario;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public TipoSolicitud getTipoSolicitud() {
        return tipoSolicitud;
    }

    public void setTipoSolicitud(TipoSolicitud tipoSolicitud) {
        this.tipoSolicitud = tipoSolicitud;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public EstadoSolicitud getEstado() {
        return estado;
    }

    public void setEstado(EstadoSolicitud estado) {
        this.estado = estado;
    }
}
