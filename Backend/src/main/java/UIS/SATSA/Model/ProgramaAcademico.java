package UIS.SATSA.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="programa_academico")
@Data
public class ProgramaAcademico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 5)
    private String codigoPrograma;

    @Column(nullable = false, length = 200)
    private String nombre;

    public ProgramaAcademico() {super();}

    public ProgramaAcademico(Integer id) {
        this.id = id;
    }
}
