package UIS.SATSA.Controller;

import UIS.SATSA.DTO.TipoSolicitudDTO;
import UIS.SATSA.Service.TipoSolicitudService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tiposolicitud")
public class TipoSolicitudController {
    private final TipoSolicitudService tipoSolicitudService;

    public TipoSolicitudController(TipoSolicitudService tipoSolicitudService, TipoSolicitudService tipoSolicitudService1) {
        this.tipoSolicitudService = tipoSolicitudService;
    }
    @GetMapping("/listar")
    public List<TipoSolicitudDTO> getTipoSolicitud() {
        return tipoSolicitudService.ListarTiposSolicitud();
    }
}
