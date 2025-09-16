package UIS.SATSA.Model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "solicitud")
public class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String detalle;

    @Column(nullable = false)
    private LocalDateTime fecha;

    @ManyToOne
    @JoinColumn(name = "tipo_solicitud_id")
    private TipoSolicitud tipoSolicitud;

    @OneToMany(mappedBy = "solicitud", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RespuestaCampo> respuestas = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_estado")
    private EstadoSolicitud estado;

    public Solicitud() {super();}

    public Solicitud(Integer id, String detalle, LocalDateTime fecha, TipoSolicitud tipoSolicitud, List<RespuestaCampo> respuestas, Usuario usuario, EstadoSolicitud estado) {
        this.id = id;
        this.detalle = detalle;
        this.fecha = fecha;
        this.tipoSolicitud = tipoSolicitud;
        this.respuestas = respuestas;
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

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public TipoSolicitud getTipoSolicitud() {
        return tipoSolicitud;
    }

    public void setTipoSolicitud(TipoSolicitud tipoSolicitud) {
        this.tipoSolicitud = tipoSolicitud;
    }

    public List<RespuestaCampo> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<RespuestaCampo> respuestas) {
        this.respuestas = respuestas;
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
