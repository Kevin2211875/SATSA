package UIS.SATSA.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class StorageService {

    private final Path root = Paths.get("upload");

    public StorageService() {
        try {
            if (!Files.exists(root)) {
                Files.createDirectories(root);
            }
        } catch (IOException e) {
            throw new RuntimeException("No se pudo inicializar la carpeta de almacenamiento.", e);
        }
    }

    // Guarda un archivo nuevo
    public String guardar(MultipartFile file) {
        try {
            String nombreArchivo = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            Path destino = root.resolve(nombreArchivo);
            Files.copy(file.getInputStream(), destino, StandardCopyOption.REPLACE_EXISTING);
            return destino.toString();
        } catch (IOException e) {
            throw new RuntimeException("No se pudo guardar el archivo: " + file.getOriginalFilename(), e);
        }
    }

    // Elimina un archivo
    public void eliminar(String ruta) {
        try {
            Files.deleteIfExists(Paths.get(ruta));
        } catch (IOException e) {
            throw new RuntimeException("Error eliminando archivo: " + ruta, e);
        }
    }

}
