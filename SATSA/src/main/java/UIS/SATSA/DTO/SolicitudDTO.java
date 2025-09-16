package UIS.SATSA.DTO;

import java.time.LocalDateTime;
import java.util.List;

import UIS.SATSA.Model.EstadoSolicitud;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SolicitudDTO {
    private Integer id;
    private String tipoSolicitud;
    private EstadoSolicitud estado;
    private LocalDateTime fechaCreacion;
    private List<RespuestaCampoDTO> respuestas;

    // constructor, getters y setters
    public SolicitudDTO(Integer id, String tipoSolicitud, EstadoSolicitud estado, LocalDateTime fechaCreacion, List<RespuestaCampoDTO> respuestas) {
        this.id = id;
        this.tipoSolicitud = tipoSolicitud;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.respuestas = respuestas;
    }
}