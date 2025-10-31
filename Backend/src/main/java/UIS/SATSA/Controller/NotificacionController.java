package UIS.SATSA.Controller;

import UIS.SATSA.Model.Notificacion;
import UIS.SATSA.Repository.NotificacionRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/notificaciones")
public class NotificacionController {

    private final NotificacionRepository notificacionRepository;

    public NotificacionController(NotificacionRepository notificacionRepository) {
        this.notificacionRepository = notificacionRepository;
    }

    @GetMapping("/{usuarioId}")
    public List<Notificacion> listarNotificaciones(@PathVariable Integer usuarioId) {
        return notificacionRepository.findByUsuarioId(usuarioId);
    }
}
