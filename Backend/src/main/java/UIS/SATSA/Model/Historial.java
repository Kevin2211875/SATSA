package UIS.SATSA.Model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "historial")
public class Historial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String comentario;

    @Column(nullable = false)
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "id_solicitud")
    private Solicitud solicitud;

    public Historial() {super();}

    public Historial(Integer id, String comentario, Date fecha, Solicitud solicitud) {
        this.id = id;
        this.comentario = comentario;
        this.fecha = fecha;
        this.solicitud = solicitud;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }
}
