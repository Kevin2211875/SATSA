package UIS.SATSA.Repository;

import UIS.SATSA.Model.Historial;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface HistorialRepository extends JpaRepository<Historial, Integer> {
    List<Historial> findBySolicitudIdOrderByFechaDesc(Integer solicitudId);

}
