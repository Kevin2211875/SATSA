package UIS.SATSA.Repository;

import UIS.SATSA.Model.CampoSolicitud;
import UIS.SATSA.Model.TipoSolicitud;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CampoSolicitudRepository extends JpaRepository<CampoSolicitud, Integer> {
    List<CampoSolicitud> findByTipoSolicitud(TipoSolicitud tipoSolicitud);
}
