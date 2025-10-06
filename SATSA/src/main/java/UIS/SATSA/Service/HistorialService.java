package UIS.SATSA.Service;

import UIS.SATSA.DTO.HistorialDTO;
import UIS.SATSA.DTO.SolicitudConHistorialDTO;
import UIS.SATSA.Model.EstadoSolicitud;
import UIS.SATSA.Model.Historial;
import UIS.SATSA.Model.Solicitud;
import UIS.SATSA.Repository.HistorialRepository;
import UIS.SATSA.Repository.SolicitudRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HistorialService  {

    @Autowired
    private final HistorialRepository historialRepository;
    private final SolicitudRepository solicitudRepository;

    public HistorialDTO HistorialtoDTO (Solicitud saved, EstadoSolicitud estadoNuevo, EstadoSolicitud estadoAnterior){
        Historial historial = new Historial();
        historial.setSolicitud(saved);
        historial.setUsuario(saved.getUsuario()); // o el admin que hizo el cambio
        historial.setEstadoAnterior(estadoAnterior);
        historial.setFecha(LocalDate.now());
        historial.setEstadoNuevo(estadoNuevo);
        historial.setComentario("Cambio de estado");
        historialRepository.save(historial);

        return new HistorialDTO(
                historial.getId(),
                historial.getComentario(),
                historial.getFecha(),
                historial.getUsuario().getApellidos() + " " + historial.getUsuario().getApellidos(),
                historial.getEstadoAnterior().getEstadoSolicitud(),
                historial.getEstadoNuevo().getEstadoSolicitud()
        );
    }

    public SolicitudConHistorialDTO ListHistorial(Integer solicitudId) {
        Solicitud solicitud = solicitudRepository.findById(solicitudId)
                .orElseThrow(() -> new RuntimeException("Solicitud no encontrada"));

        List<HistorialDTO> historialDTOs = historialRepository.findBySolicitudIdOrderByFechaDesc(solicitudId)
                .stream()
                .map(h -> new HistorialDTO(
                        h.getId(),
                        h.getComentario(),
                        h.getFecha(),
                        h.getUsuario().getNombres() + " " + h.getUsuario().getApellidos(),
                        h.getEstadoAnterior() != null ? h.getEstadoAnterior().getEstadoSolicitud() : null,
                        h.getEstadoNuevo() != null ? h.getEstadoNuevo().getEstadoSolicitud() : null
                ))
                .toList();
        return new SolicitudConHistorialDTO(
                solicitud.getId(),
                solicitud.getNumeroSolicitud(),
                solicitud.getDetalle(),
                solicitud.getEstado().getEstadoSolicitud(),
                solicitud.getTipoSolicitud().getNombre(),
                solicitud.getUsuario().getNombres() + " " + solicitud.getUsuario().getApellidos(),
                historialDTOs
        );

    }
}
