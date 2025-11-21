package UIS.SATSA.Repository;

import UIS.SATSA.Model.TipoSolicitud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TipoSolicitudRepository extends JpaRepository<TipoSolicitud, Integer> {

    @Query(value = "SELECT * FROM TipoSolicitud",  nativeQuery = true)
    List<TipoSolicitud> listaTipoSolicitud();
}
