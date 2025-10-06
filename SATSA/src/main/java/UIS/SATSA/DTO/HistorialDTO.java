package UIS.SATSA.DTO;

import UIS.SATSA.Model.EstadoSolicitud;
import UIS.SATSA.Model.Solicitud;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class HistorialDTO {

    private Integer id;

    private String comentario;

    private LocalDate fecha;

    private String usuario; // quien hizo el cambio

    private String estadoAnterior;

    private String estadoNuevo;
}
