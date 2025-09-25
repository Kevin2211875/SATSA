package UIS.SATSA.Repository;

import UIS.SATSA.Model.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SolicitudRepository extends JpaRepository<Solicitud, Integer> {
    @Query(value = "SELECT * FROM solicitud WHERE campos ->> 'numeroSolicitud' = :numeroSolicitud", nativeQuery = true)
    Optional<Solicitud> findByNumeroSolicitud(@Param("numeroSolicitud") String numeroSolicitud);

    @Query(value = """
        SELECT s.* 
        FROM solicitud s
        JOIN usuario u ON s.id_usuario = u.id
        WHERE u.codigo = :codigo
    """, nativeQuery = true)
    List<Solicitud> listarSolicitudes(@Param("codigo") String codigo);

    @Query(value = "SELECT *\n" +
            "FROM solicitud s\n" +
            "JOIN estado_solicitud e ON s.id_estado = e.id\n" +
            "ORDER BY \n" +
            "    CASE WHEN e.estado_solicitud  = 'En espera' THEN 1 ELSE 2 END,\n" +
            "    s.fecha_solicitud ASC;", nativeQuery = true)
    List<Solicitud> listaSolicitudesPrioridad();

}
