package UIS.SATSA.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class NotificacionDTO implements Serializable {
    private Integer usuarioId;
    private String email;
    private String numeroSolicitud;
    private String tipoSolicitud;
    private String nuevoEstado;
    private LocalDate Fecha;
}
