package UIS.SATSA.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "token")
@Data
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String token;

    @Enumerated(EnumType.STRING)
    private TokenType tokenType = TokenType.BEARER;

    @Column(name = "is_expired", nullable = false)
    private Boolean expired; // Cambiado de isExpired a expired

    @Column(name = "is_revoked", nullable = false)
    private Boolean revoked; // Cambiado de isRevoked a revoked

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    private Usuario user;

    public Token() {super();}

    public enum TokenType {
        BEARER
    }

}
