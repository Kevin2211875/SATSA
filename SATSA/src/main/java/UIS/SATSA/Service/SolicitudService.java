package UIS.SATSA.Service;

import UIS.SATSA.DTO.CrearSolicitudRequest;
import UIS.SATSA.DTO.SolicitudDTO;
import UIS.SATSA.Model.Solicitud;
import UIS.SATSA.Model.Usuario;
import UIS.SATSA.Repository.EstadoSolicitudRepository;
import UIS.SATSA.Repository.SolicitudRepository;
import UIS.SATSA.Repository.TipoSolicitudRepository;
import UIS.SATSA.Repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class SolicitudService {

    private final EstadoSolicitudRepository estadoSolicitudRepository;
    private final SolicitudRepository solicitudRepository;
    private final UsuarioRepository usuarioRepository;
    private final TipoSolicitudRepository tipoSolicitudRepository;
    private final ObjectMapper mapper = new ObjectMapper();

    public SolicitudService(EstadoSolicitudRepository estadoSolicitudRepository, SolicitudRepository solicitudRepository,
                            UsuarioRepository usuarioRepository, TipoSolicitudRepository tipoSolicitudRepository) {
        this.estadoSolicitudRepository = estadoSolicitudRepository;
        this.solicitudRepository = solicitudRepository;
        this.usuarioRepository = usuarioRepository;
        this.tipoSolicitudRepository = tipoSolicitudRepository;
    }

    @Transactional
    public SolicitudDTO crearSolicitud(CrearSolicitudRequest request) {
        var usuario = usuarioRepository.findById(request.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        var estado = estadoSolicitudRepository.findById(request.getEstadoId())
                .orElseThrow(() -> new RuntimeException("Estado no encontrado"));

        var tipo = tipoSolicitudRepository.findById(request.getTipoSolicitudId())
                .orElseThrow(() -> new RuntimeException("Tipo de solicitud no encontrado"));

        try {
            // Campos requeridos se obtienen de TipoSolicitud
            Map<String, Boolean> camposRequeridos =
                    mapper.readValue(tipo.getCampos(), Map.class);

            Map<String, Object> camposRequest = request.getCampos();

            for (Map.Entry<String, Boolean> entry : camposRequeridos.entrySet()) {
                if (entry.getValue() && !camposRequest.containsKey(entry.getKey())) {
                    throw new IllegalArgumentException(
                            "Falta el campo requerido: " + entry.getKey()
                    );
                }
            }

            // Crear la entidad Solicitud
            Solicitud solicitud = new Solicitud();
            solicitud.setUsuario(usuario);
            solicitud.setTipoSolicitud(tipo);
            solicitud.setEstado(estado);
            solicitud.setFechaSolicitud(LocalDateTime.now());
            solicitud.setDetalle(request.getDetalle()); // texto libre
            solicitud.setCampos(camposRequest); // JSON dinámico

            Solicitud saved = solicitudRepository.save(solicitud);

            return new SolicitudDTO(
                    saved.getId(),
                    saved.getFechaSolicitud(),
                    saved.getDetalle(),
                    saved.getCampos(),
                    saved.getTipoSolicitud().getNombre(),
                    saved.getEstado().getEstadoSolicitud(),
                    saved.getUsuario().getNombres() + " " + saved.getUsuario().getApellidos()
            );

        } catch (Exception e) {
            throw new RuntimeException("Error procesando JSON de campos requeridos", e);
        }
    }

    @Transactional
    public SolicitudDTO buscarSolicitudPorId(String numeroSolicitud) {
        Solicitud solicitud = solicitudRepository.findByNumeroSolicitud(numeroSolicitud).orElseThrow(()
                -> new RuntimeException("Solicitud no encontrada"));

        return new SolicitudDTO(
                solicitud.getId(),
                solicitud.getFechaSolicitud(),
                solicitud.getDetalle(),
                solicitud.getCampos(),
                solicitud.getTipoSolicitud().getNombre(),
                solicitud.getEstado().getEstadoSolicitud(),
                solicitud.getUsuario().getNombres() + " " + solicitud.getUsuario().getApellidos()
        );
    }

    @Transactional
    public List<SolicitudDTO> listarSolicitudes(String codigo) {

        Usuario user = usuarioRepository.findByCodigo(codigo).orElseThrow(()
                -> new RuntimeException("Solicitud no encontrada"));

        List<Solicitud> solicitudes = solicitudRepository.listarSolicitudes(user.getId());
        solicitudes = solicitudRepository.listaSolicitudesPrioridad();
        List<SolicitudDTO> listaSolicitudes = new ArrayList<>();

        for (Solicitud saved : solicitudes) {
            listaSolicitudes.add(new SolicitudDTO(
                    saved.getId(),
                    saved.getFechaSolicitud(),
                    saved.getDetalle(),
                    saved.getCampos(),
                    saved.getTipoSolicitud().getNombre(),
                    saved.getEstado().getEstadoSolicitud(),
                    saved.getUsuario().getNombres() + " " + saved.getUsuario().getApellidos()));
        }

        return listaSolicitudes;
    }

    @Transactional
    public SolicitudDTO emitirRespuesta(CrearSolicitudRequest request, String numeroSolicitud) {
        Solicitud solicitud = solicitudRepository.findByNumeroSolicitud(numeroSolicitud).orElseThrow(()
                -> new RuntimeException("Solicitud no encontrada"));

        var estado = estadoSolicitudRepository.findById(request.getEstadoId())
                .orElseThrow(() -> new RuntimeException("Estado no encontrado"));

        try {
            // Campos requeridos se obtienen de TipoSolicitud
            Map<String, Boolean> camposRequeridos =
                    mapper.readValue(solicitud.getTipoSolicitud().getCampos(), Map.class);

            Map<String, Object> camposRequest = request.getCampos();

            for (Map.Entry<String, Boolean> entry : camposRequeridos.entrySet()) {
                if (entry.getValue() && !camposRequest.containsKey(entry.getKey())) {
                    throw new IllegalArgumentException(
                            "Falta el campo requerido: " + entry.getKey()
                    );
                }
            }

            // Crear la entidad Solicitud
            solicitud.setEstado(estado);
            solicitud.setCampos(camposRequest);

            Solicitud saved = solicitudRepository.save(solicitud);

            return new SolicitudDTO(
                    saved.getId(),
                    saved.getFechaSolicitud(),
                    saved.getDetalle(),
                    saved.getCampos(),
                    saved.getTipoSolicitud().getNombre(),
                    saved.getEstado().getEstadoSolicitud(),
                    saved.getUsuario().getNombres() + " " + saved.getUsuario().getApellidos()
            );

        } catch (Exception e) {
            throw new RuntimeException("Error procesando JSON de campos requeridos", e);
        }
    }
}
