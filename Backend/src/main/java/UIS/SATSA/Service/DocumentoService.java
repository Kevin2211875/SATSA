package UIS.SATSA.Service;

import UIS.SATSA.Model.Documento;
import UIS.SATSA.Model.Solicitud;
import UIS.SATSA.Repository.DocumentoRepository;
import UIS.SATSA.Repository.SolicitudRepository;
import jakarta.transaction.Transactional;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

@Service
@Data
public class DocumentoService {

    private final DocumentoRepository documentoRepository;
    private final SolicitudRepository solicitudRepository;
    private final StorageService storageService;

    @Transactional
    public Documento adjuntarDocumento(Integer solicitudId, MultipartFile multipartFile) {
        Solicitud solicitud = solicitudRepository.findById(solicitudId)
                .orElseThrow(() -> new RuntimeException("Solicitud no encontrada"));

        String rutaDocumento = storageService.guardar(multipartFile);
        Documento doc = new Documento();
        doc.setNombre(multipartFile.getOriginalFilename());
        doc.setRutaDocumento(rutaDocumento);
        doc.setFecha(LocalDate.now());
        doc.setSolicitud(solicitud);

        return documentoRepository.save(doc);
    }

    //obtener todos los documentos relacionados a una solicitud
    public List<Documento> obtenerDocumentosPorSolicitud(Integer solicitudId) {
        return documentoRepository.findBySolicitudId(solicitudId);
    }


    //actualizar documento/s existente
    @Transactional
    public Documento actualizarDocumento(Integer documentoId, MultipartFile nuevoArchivo) {
        Documento documento = documentoRepository.findById(documentoId)
                .orElseThrow(() -> new RuntimeException("Documento no encontrado"));

        // Borrar el archivo viejo
        storageService.eliminar(documento.getRutaDocumento());

        // Guardar el nuevo archivo
        String nuevaRuta = storageService.guardar(nuevoArchivo);
        documento.setRutaDocumento(nuevaRuta);
        documento.setFecha(LocalDate.now());
        documento.setNombre(nuevoArchivo.getOriginalFilename());

        return documentoRepository.save(documento);
    }


    //eliminar un documento
    @Transactional
    public void eliminarDocumento(Integer documentoId) {
        Documento documento = documentoRepository.findById(documentoId)
                .orElseThrow(() -> new RuntimeException("Documento no encontrado"));

        storageService.eliminar(documento.getRutaDocumento());
        documentoRepository.delete(documento);
    }
}
