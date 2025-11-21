package UIS.SATSA.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "grupo")
@Data
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 4)
    private String codigo;

    @ManyToOne
    @JoinColumn(name = "id_asignatura")
    private Asignatura asignatura;

    @ManyToOne
    @JoinColumn(name = "id_profesor")
    private Profesor profesor;

    public Grupo() {super();}

}
