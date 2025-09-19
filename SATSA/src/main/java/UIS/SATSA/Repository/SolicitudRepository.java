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

    @Query(value = "SELECT * FROM solicitud WHERE id_usuario = :usuarioId", nativeQuery = true)
    List<Solicitud> listarSolicitudes(@Param("usuarioId") Integer usuarioId);



}
