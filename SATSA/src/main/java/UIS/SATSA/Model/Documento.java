package UIS.SATSA.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "documentos")
@Getter
@Setter
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 200)
    private String nombre;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(nullable = false, length = 500)
    private String rutaDocumento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_solicitud", nullable = false)
    private Solicitud solicitud;

    public Documento() {super();}

    public Documento(Integer id, String nombre, LocalDate fecha, String rutaDocumento, Solicitud solicitud) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.rutaDocumento = rutaDocumento;
        this.solicitud = solicitud;
    }
}
