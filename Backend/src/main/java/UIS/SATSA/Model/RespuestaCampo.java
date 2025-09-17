package UIS.SATSA.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "respuesta_campo")
public class RespuestaCampo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String valor;

    @ManyToOne
    @JoinColumn(name = "solicitud_id")
    private Solicitud solicitud;

    @ManyToOne
    @JoinColumn(name = "campo_solicitud_id")
    private CampoSolicitud campo;

    public RespuestaCampo() {super();}

    public RespuestaCampo(Integer id, String valor, Solicitud solicitud, CampoSolicitud campo) {
        this.id = id;
        this.valor = valor;
        this.solicitud = solicitud;
        this.campo = campo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }

    public CampoSolicitud getCampo() {
        return campo;
    }

    public void setCampo(CampoSolicitud campo) {
        this.campo = campo;
    }
}
