package UIS.SATSA.DTO;


import lombok.Getter;
import lombok.Setter;
import java.util.Map;

@Getter
@Setter
public class CrearSolicitudRequest {

    public Integer usuarioId;
    public Integer tipoSolicitudId;
    public Integer estadoId;
    public String detalle;
    public Map<String, Object> campos;

    public CrearSolicitudRequest() {super();}

    public CrearSolicitudRequest(Integer usuarioId, Integer tipoSolicitudId,
                                 Integer estadoId, String detalle, Map<String, Object> campos) {
        this.usuarioId = usuarioId;
        this.tipoSolicitudId = tipoSolicitudId;
        this.estadoId = estadoId;
        this.detalle = detalle;
        this.campos = campos;
    }
}
