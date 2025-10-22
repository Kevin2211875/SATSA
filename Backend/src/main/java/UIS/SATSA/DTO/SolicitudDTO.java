package UIS.SATSA.DTO;

import java.time.LocalDateTime;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SolicitudDTO {

    private Integer id;
    private LocalDateTime fechaSolicitud;
    private String detalle;
    private String numeroSolicitud;
    private Map<String, Object> campos;
    private String tipoSolicitud;
    private String estado;
    private String usuario;

    public SolicitudDTO() {super();}

}