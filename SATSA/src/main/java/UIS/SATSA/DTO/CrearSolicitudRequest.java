package UIS.SATSA.DTO;


import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class CrearSolicitudRequest {

    private Integer usuarioId;
    private Integer tipoSolicitudId;
    private Integer estadoId;
    private String detalle;
    private List<RespuestaCampoDTO> respuestas;

    public CrearSolicitudRequest() {super();}

    public CrearSolicitudRequest(String detalle, Integer usuarioId, Integer tipoSolicitudId, Integer estadoId, List<RespuestaCampoDTO> respuestas) {
        this.usuarioId = usuarioId;
        this.tipoSolicitudId = tipoSolicitudId;
        this.estadoId = estadoId;
        this.respuestas = respuestas;
        this.detalle = detalle;
    }
}
