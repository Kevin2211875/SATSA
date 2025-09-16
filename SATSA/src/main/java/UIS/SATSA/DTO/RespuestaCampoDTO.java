package UIS.SATSA.DTO;

import UIS.SATSA.Model.CampoSolicitud;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RespuestaCampoDTO {
    private Integer campoId;
    private String nombreCampo;
    private String valor;
    private CampoSolicitud campo;


    public RespuestaCampoDTO(Integer campoId, String nombreCampo, String valor) {
        this.campoId = campoId;
        this.nombreCampo = nombreCampo;
        this.valor = valor;
    }

}