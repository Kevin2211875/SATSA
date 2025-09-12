package UIS.SATSA.Repository;

import UIS.SATSA.Model.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitudReposittory extends JpaRepository<Solicitud, Integer> {
}
