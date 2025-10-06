package UIS.SATSA.Service;

import UIS.SATSA.Model.Documento;
import UIS.SATSA.Model.Solicitud;
import UIS.SATSA.Repository.DocumentoRepository;
import UIS.SATSA.Repository.SolicitudRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class DocumentoService {

    private final DocumentoRepository documentoRepository;
    private final SolicitudRepository solicitudRepository;

    public DocumentoService(DocumentoRepository documentoRepository, SolicitudRepository solicitudRepository) {
        this.documentoRepository = documentoRepository;
        this.solicitudRepository = solicitudRepository;
    }

    @Transactional
    public Documento adjuntarDocumento(Integer solicitudId, String nombre, String rutaDocumento) {
        Solicitud solicitud = solicitudRepository.findById(solicitudId)
                .orElseThrow(() -> new RuntimeException("Solicitud no encontrada"));

        Documento doc = new Documento();
        doc.setNombre(nombre);
        doc.setRutaDocumento(rutaDocumento);
        doc.setFecha(LocalDate.now());
        doc.setSolicitud(solicitud);

        return documentoRepository.save(doc);
    }

    public List<Documento> obtenerDocumentosPorSolicitud(Integer solicitudId) {
        return documentoRepository.findBySolicitudId(solicitudId);
    }
}
