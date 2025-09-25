package UIS.SATSA.Controller;

import UIS.SATSA.DTO.CrearSolicitudRequest;
import UIS.SATSA.DTO.SolicitudDTO;
import UIS.SATSA.Model.EstadoSolicitud;
import UIS.SATSA.Service.SolicitudService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/solicitud")
public class SolicitudController {

    private final SolicitudService solicitudService;

    public SolicitudController(SolicitudService solicitudService) {
        this.solicitudService = solicitudService;
    }

    @PostMapping("/crear")
    public SolicitudDTO crearSolicitud(@RequestBody CrearSolicitudRequest request) {
        return solicitudService.crearSolicitud(request);
    }

    @GetMapping("/detalle/{numeroSolicitud}")
    public ResponseEntity<SolicitudDTO> obtenerSolicitud(@PathVariable String numeroSolicitud) {
        return ResponseEntity.ok(solicitudService.buscarSolicitudPorId(numeroSolicitud));
    }

    @GetMapping("/listarSolicitudes/{codigo}")
    public List<SolicitudDTO> listarSolicitudes(@PathVariable String codigo) {
        return solicitudService.listarSolicitudes(codigo);
    }

    @PutMapping("/emitirRespuesta/{numeroSolicitud}")
    public  SolicitudDTO emitirRespuesta(@RequestBody CrearSolicitudRequest request, @PathVariable String numeroSolicitud) {
        return solicitudService.emitirRespuesta(request, numeroSolicitud);
    }
}
