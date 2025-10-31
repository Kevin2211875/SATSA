package UIS.SATSA.Repository;

import UIS.SATSA.Model.Documento;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DocumentoRepository extends JpaRepository<Documento, Integer> {
    List<Documento> findBySolicitudId(Integer solicitudId);
}
