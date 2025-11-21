package UIS.SATSA.Service;

import UIS.SATSA.DTO.NotificacionDTO;
import UIS.SATSA.Model.EstadoSolicitud;
import UIS.SATSA.Model.Notificacion;
import UIS.SATSA.Model.Solicitud;
import UIS.SATSA.Repository.NotificacionRepository;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

@Service
@AllArgsConstructor
public class NotificacionService  {
    private NotificacionRepository notificacionRepository;
    private final RabbitTemplate rabbitTemplate;

    public NotificacionDTO nofiticaciontoDto(Solicitud solicitud, EstadoSolicitud estadoNevo) {

        Notificacion notificacion = new Notificacion();
        notificacion.setUsuarioId(solicitud.getUsuario().getId());
        notificacion.setUsuarioEmail(solicitud.getUsuario().getEmail());
        notificacion.setNumeroSolicitud(solicitud.getNumeroSolicitud());
        notificacion.setTipoSolicitud(solicitud.getTipoSolicitud().getNombre());
        notificacion.setNuevoEstado(estadoNevo.getEstadoSolicitud());
        notificacion.setFecha(LocalDate.now());
        notificacionRepository.save(notificacion);

        NotificacionDTO notificacionDTO = new NotificacionDTO(
                solicitud.getUsuario().getId(),
                solicitud.getUsuario().getEmail(),
                (String) solicitud.getNumeroSolicitud(),
                solicitud.getTipoSolicitud().getNombre(),
                estadoNevo.getEstadoSolicitud(),
                LocalDate.now()
        );

        rabbitTemplate.convertAndSend("notificaciones.exchange", "solicitud.estado", notificacionDTO);

        return notificacionDTO;
    }
}
