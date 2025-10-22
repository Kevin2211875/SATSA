package UIS.SATSA.Repository;

import UIS.SATSA.Model.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SolicitudRepository extends JpaRepository<Solicitud, Integer> {
    @Query(value = "SELECT * FROM solicitud s WHERE s.numero_solicitud = :numeroSolicitud", nativeQuery = true)
    Optional<Solicitud> findByNumeroSolicitud(@Param("numeroSolicitud") String numeroSolicitud);

    @Query(value = "SELECT * FROM solicitud WHERE id_usuario = :usuarioId", nativeQuery = true)
    List<Solicitud> listarSolicitudes(@Param("usuarioId") Integer usuarioId);

    @Query(value = "SELECT s.*\n" +
            "FROM solicitud s\n" +
            "JOIN estado_solicitud e ON s.id_estado = e.id\n" +
            "ORDER BY \n" +
            "    s.fecha_solicitud,  -- primero las más recientes\n" +
            "    CASE \n" +
            "        WHEN e.id = 1 THEN 1  -- \"En espera\"\n" +
            "        WHEN e.id = 2 THEN 2    -- \"Rechazada\"\n" +
            "        ELSE 5\n" +
            "    end;", nativeQuery = true)
    List<Solicitud> listaSolicitudesPrioridad();

}
