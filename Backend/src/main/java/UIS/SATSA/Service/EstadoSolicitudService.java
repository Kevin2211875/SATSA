package UIS.SATSA.Service;

import UIS.SATSA.Model.EstadoSolicitud;
import UIS.SATSA.Repository.EstadoSolicitudRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class EstadoSolicitudService implements EstadoSolicitudRepository {
    @Override
    public void flush() {

    }

    @Override
    public <S extends EstadoSolicitud> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends EstadoSolicitud> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<EstadoSolicitud> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public EstadoSolicitud getOne(Integer integer) {
        return null;
    }

    @Override
    public EstadoSolicitud getById(Integer integer) {
        return null;
    }

    @Override
    public EstadoSolicitud getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends EstadoSolicitud> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends EstadoSolicitud> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends EstadoSolicitud> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends EstadoSolicitud> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends EstadoSolicitud> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends EstadoSolicitud> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends EstadoSolicitud, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends EstadoSolicitud> S save(S entity) {
        return null;
    }

    @Override
    public <S extends EstadoSolicitud> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<EstadoSolicitud> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<EstadoSolicitud> findAll() {
        return List.of();
    }

    @Override
    public List<EstadoSolicitud> findAllById(Iterable<Integer> integers) {
        return List.of();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(EstadoSolicitud entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends EstadoSolicitud> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<EstadoSolicitud> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<EstadoSolicitud> findAll(Pageable pageable) {
        return null;
    }
}
