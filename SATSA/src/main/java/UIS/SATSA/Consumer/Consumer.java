package UIS.SATSA.Consumer;

import UIS.SATSA.Config.RabbitMQConfig;
import UIS.SATSA.DTO.NotificacionDTO;
import UIS.SATSA.Model.Notificacion;
import UIS.SATSA.Repository.NotificacionRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    private final NotificacionRepository notificacionRepository;
    private final SimpMessagingTemplate messagingTemplate;

    @Autowired
    public Consumer(NotificacionRepository notificacionRepository,
                    SimpMessagingTemplate messagingTemplate) {
        this.notificacionRepository = notificacionRepository;
        this.messagingTemplate = messagingTemplate;
    }

    @RabbitListener(queues = RabbitMQConfig.NOTIFICACIONES_QUEUE)
    public void recibirNotificacion(NotificacionDTO dto) {
        Notificacion notificacion = new Notificacion(
                null,
                dto.getUsuarioId(),
                dto.getEmail(),
                dto.getNumeroSolicitud(),
                dto.getTipoSolicitud(),
                dto.getNuevoEstado(),
                dto.getFecha()
        );
        notificacionRepository.save(notificacion);

        // Enviar por WebSocket
        messagingTemplate.convertAndSend(
                "/topic/notificaciones/" + dto.getUsuarioId(),
                dto
        );
    }

}
