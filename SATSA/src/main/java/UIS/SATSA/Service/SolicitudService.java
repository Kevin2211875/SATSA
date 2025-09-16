package UIS.SATSA.Service;

import UIS.SATSA.DTO.CrearSolicitudRequest;
import UIS.SATSA.DTO.RespuestaCampoDTO;
import UIS.SATSA.DTO.SolicitudDTO;
import UIS.SATSA.Exception.ResourceNotFoundException;
import UIS.SATSA.Model.*;
import UIS.SATSA.Repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SolicitudService {

    private final SolicitudRepository solicitudRepository;
    private final TipoSolicitudRepository tipoSolicitudRepository;
    private final EstadoSolicitudRepository estadoSolicitudRepository;
    private final UsuarioRepository usuarioRepository;
    private final RespuestaCampoRepository respuestaCampoRepository;

    @Autowired
    private CampoSolicitudRepository campoSolicitudRepository;

    public SolicitudService(
            SolicitudRepository solicitudRepository,
            TipoSolicitudRepository tipoSolicitudRepository, EstadoSolicitudRepository estadoSolicitudRepository,
            UsuarioRepository usuarioRepository,
            RespuestaCampoRepository respuestaCampoRepository) {
        this.solicitudRepository = solicitudRepository;
        this.tipoSolicitudRepository = tipoSolicitudRepository;
        this.estadoSolicitudRepository = estadoSolicitudRepository;
        this.usuarioRepository = usuarioRepository;
        this.respuestaCampoRepository = respuestaCampoRepository;
    }

    @Transactional
    public Solicitud crearSolicitud(CrearSolicitudRequest request) {
        Usuario usuario = usuarioRepository.findById(request.getUsuarioId())
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));
        TipoSolicitud tipoSolicitud = tipoSolicitudRepository.findById(request.getTipoSolicitudId())
                .orElseThrow(() -> new IllegalArgumentException("Tipo de solicitud no encontrado"));
        EstadoSolicitud estado = estadoSolicitudRepository.findById(request.getEstadoId())
                .orElseThrow(() -> new IllegalArgumentException("Estado no encontrado"));



        Solicitud solicitud = new Solicitud();
        solicitud.setUsuario(usuario);
        solicitud.setTipoSolicitud(tipoSolicitud);
        solicitud.setEstado(estado);
        solicitud.setDetalle(request.getDetalle());
        solicitud.setFecha(LocalDateTime.now());

        if (request.getRespuestas() != null) {
            for (RespuestaCampoDTO r : request.getRespuestas()) {
                RespuestaCampo respuesta = new RespuestaCampo();
                respuesta.setValor(r.getValor());
                respuesta.setSolicitud(solicitud);

                CampoSolicitud campo = campoSolicitudRepository.findById(r.getCampoId())
                        .orElseThrow(() -> new ResourceNotFoundException("Campo no encontrado con id " + r.getCampoId()));
                respuesta.setCampo(campo);
            }
        }

        return solicitudRepository.save(solicitud);
    }

    @Transactional
    public SolicitudDTO obtenerSolicitud(Integer solicitudId) {
        Solicitud solicitud = solicitudRepository.findById(solicitudId)
                .orElseThrow(() -> new IllegalArgumentException("Solicitud no encontrada"));

        List<RespuestaCampoDTO> respuestas = solicitud.getRespuestas().stream()
                .map(r -> new RespuestaCampoDTO(r.getCampo().getId(), r.getCampo().getNombreCampo(), r.getValor()))
                .collect(Collectors.toList());

        return new SolicitudDTO(
                solicitud.getId(),
                solicitud.getTipoSolicitud().getTipoSolicitud(),
                solicitud.getEstado(),
                solicitud.getFecha(),
                respuestas
        );
    }
}
