package UIS.SATSA.Controller;

import UIS.SATSA.DTO.CrearSolicitudRequest;
import UIS.SATSA.DTO.SolicitudDTO;
import UIS.SATSA.Model.Solicitud;
import UIS.SATSA.Service.SolicitudService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/solicitud")
public class SolicitudController {

    private final SolicitudService solicitudService;

    public SolicitudController(SolicitudService solicitudService) {
        this.solicitudService = solicitudService;
    }

    @PostMapping("/register")
    public ResponseEntity<SolicitudDTO> crearSolicitud(@RequestBody CrearSolicitudRequest request) {
        Solicitud solicitud = solicitudService.crearSolicitud(request);
        SolicitudDTO dto = solicitudService.obtenerSolicitud(solicitud.getId());
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/detalle/{id}")
    public ResponseEntity<SolicitudDTO> obtenerSolicitud(@PathVariable Integer id) {
        return ResponseEntity.ok(solicitudService.obtenerSolicitud(id));
    }
}
