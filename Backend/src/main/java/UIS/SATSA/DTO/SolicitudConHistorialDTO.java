package UIS.SATSA.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class SolicitudConHistorialDTO {
    private Integer solicitudId;
    private String numeroSolicitud;
    private String detalle;
    private String estadoActual;
    private String tipoSolicitud;
    private String usuario; // dueño de la solicitud
    private List<HistorialDTO> historial;
}