package UIS.SATSA.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "campo_solicitud")
public class CampoSolicitud {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombreCampo;
    private String tipoDato;
    private boolean requerido;

    @ManyToOne
    @JoinColumn(name = "tipo_solicitud_id")
    private TipoSolicitud tipoSolicitud;

    public CampoSolicitud() {super();}

    public CampoSolicitud(Integer id, String nombreCampo, String tipoDato, boolean requerido, TipoSolicitud tipoSolicitud) {
        this.id = id;
        this.nombreCampo = nombreCampo;
        this.tipoDato = tipoDato;
        this.requerido = requerido;
        this.tipoSolicitud = tipoSolicitud;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreCampo() {
        return nombreCampo;
    }

    public void setNombreCampo(String nombreCampo) {
        this.nombreCampo = nombreCampo;
    }

    public String getTipoDato() {
        return tipoDato;
    }

    public void setTipoDato(String tipoDato) {
        this.tipoDato = tipoDato;
    }

    public boolean isRequerido() {
        return requerido;
    }

    public void setRequerido(boolean requerido) {
        this.requerido = requerido;
    }

    public TipoSolicitud getTipoSolicitud() {
        return tipoSolicitud;
    }

    public void setTipoSolicitud(TipoSolicitud tipoSolicitud) {
        this.tipoSolicitud = tipoSolicitud;
    }
}