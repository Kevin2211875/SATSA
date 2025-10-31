package UIS.SATSA.Controller;

import UIS.SATSA.Model.Documento;
import UIS.SATSA.Service.DocumentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/documentos")
public class DocumentoController {

    private final DocumentoService documentoService;

    public DocumentoController(DocumentoService documentoService) {
        this.documentoService = documentoService;
    }

    @PostMapping("/adjuntar")
    public ResponseEntity<Documento> adjuntarDocumento(
            @RequestParam Integer solicitudId,
            @RequestParam MultipartFile file) {

        Documento doc = documentoService.adjuntarDocumento(solicitudId, file);
        return ResponseEntity.ok(doc);
    }

    @GetMapping("/solicitud/{id}")
    public ResponseEntity<List<Documento>> obtenerDocumentosPorSolicitud(@PathVariable Integer id) {
        return ResponseEntity.ok(documentoService.obtenerDocumentosPorSolicitud(id));
    }

    @PutMapping("/{documentoId}/actualizar")
    public ResponseEntity<Documento> actualizarDocumento(
            @PathVariable Integer documentoId,
            @RequestParam("file") MultipartFile newFile
    ){
        Documento doc = documentoService.actualizarDocumento(documentoId, newFile);
        return ResponseEntity.ok(doc);
    }

    @DeleteMapping("/{documentoId}/eliminar")
    public ResponseEntity<Void> eliminarDocumento(@PathVariable Integer documentoId) {
        documentoService.eliminarDocumento(documentoId);
        return ResponseEntity.noContent().build();
    }
}