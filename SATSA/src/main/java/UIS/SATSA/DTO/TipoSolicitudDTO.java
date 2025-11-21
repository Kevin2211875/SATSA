package UIS.SATSA.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class TipoSolicitudDTO {
    private Integer id;
    private String nombre;
    private String informacion;
    private boolean disabled;
    private Map<String,Boolean> campos;

    public TipoSolicitudDTO() {super();}
}
