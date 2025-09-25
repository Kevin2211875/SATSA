package UIS.SATSA.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "profesor")
@Data
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 150)
    private String nombres;

    @Column(nullable = false, length = 150)
    private String apellidos;

    @Column(nullable = false, length = 250, name = "correo", unique = true)
    private String correo;

    public Profesor() {super();}

}
