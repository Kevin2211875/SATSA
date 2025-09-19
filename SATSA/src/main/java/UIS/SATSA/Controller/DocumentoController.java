package UIS.SATSA.Controller;

import UIS.SATSA.Model.Documento;
import UIS.SATSA.Service.DocumentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
            @RequestParam String nombre,
            @RequestParam String rutaDocumento) {

        Documento doc = documentoService.adjuntarDocumento(solicitudId, nombre, rutaDocumento);
        return ResponseEntity.ok(doc);
    }

    @GetMapping("/solicitud/{id}")
    public ResponseEntity<List<Documento>> obtenerDocumentosPorSolicitud(@PathVariable Integer id) {
        return ResponseEntity.ok(documentoService.obtenerDocumentosPorSolicitud(id));
    }
}