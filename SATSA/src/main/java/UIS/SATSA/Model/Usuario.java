package UIS.SATSA.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Table(name = "usuario")
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100, unique = true)
    private String codigo;

    @Column(nullable = false, length = 250, name = "correo", unique = true)
    private String email;

    @Column(nullable = false, length = 200)
    private String contrasena;

    @Column(nullable = false, length = 150)
    private String nombres;

    @Column(nullable = false, length = 150)
    private String apellidos;

    @Column(nullable = false, length = 15)
    private String telefono;

    @Column(nullable = false)
    private boolean cuenta_activa = true;

    @OneToOne
    @JoinColumn(name = "id_programa")
    private ProgramaAcademico programa;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Token> tokens;

    public Usuario() {super();}

    public Usuario(Integer id, String codigo, String email, String contrasena, String nombres, String apellidos, String telefono,
                   boolean cuenta_activa, ProgramaAcademico programa, List<Token> tokens) {
        this.id = id;
        this.codigo = codigo;
        this.email = email;
        this.contrasena = contrasena;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.cuenta_activa = cuenta_activa;
        this.programa = programa;
        this.tokens = tokens;
    }
}

