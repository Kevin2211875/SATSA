package UIS.SATSA.DTO;

import java.time.LocalDateTime;
import java.util.Map;

import UIS.SATSA.Model.EstadoSolicitud;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SolicitudDTO {

    private Integer id;
    private LocalDateTime fechaSolicitud;
    private String detalle;
    private Map<String, Object> campos;
    private String tipoSolicitud;
    private String estado;
    private String usuario;

    public SolicitudDTO() {super();}

    public SolicitudDTO(Integer id, LocalDateTime fechaSolicitud, String detalle, Map<String, Object> campos,
                        String tipoSolicitud, String estado, String usuario) {
        this.id = id;
        this.fechaSolicitud = fechaSolicitud;
        this.detalle = detalle;
        this.campos = campos;
        this.tipoSolicitud = tipoSolicitud;
        this.estado = estado;
        this.usuario = usuario;
    }
}