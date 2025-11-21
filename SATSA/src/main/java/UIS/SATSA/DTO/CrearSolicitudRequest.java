package UIS.SATSA.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class CrearSolicitudRequest {

    public Integer usuarioId;
    public Integer tipoSolicitudId;
    public Integer estadoId;
    public String numeroSolicitud;
    public String detalle;
    public Map<String, Object> campos;

    public CrearSolicitudRequest() {super();}

}
