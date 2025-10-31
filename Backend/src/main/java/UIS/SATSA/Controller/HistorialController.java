package UIS.SATSA.Controller;

import UIS.SATSA.DTO.SolicitudConHistorialDTO;
import UIS.SATSA.Service.HistorialService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class HistorialController {
    private final HistorialService historialService;

    @GetMapping("/{solicitudId}/historial")
    public ResponseEntity<SolicitudConHistorialDTO> getHistorial(@PathVariable Integer solicitudId) {
        return ResponseEntity.ok(historialService.ListHistorial(solicitudId));
    }
}
