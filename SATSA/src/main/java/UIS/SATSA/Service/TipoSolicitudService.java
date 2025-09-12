package UIS.SATSA.Service;

import UIS.SATSA.Model.TipoSolicitud;
import UIS.SATSA.Repository.TipoSolicitudRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class TipoSolicitudService implements TipoSolicitudRepository {
    @Override
    public void flush() {

    }

    @Override
    public <S extends TipoSolicitud> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends TipoSolicitud> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<TipoSolicitud> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public TipoSolicitud getOne(Integer integer) {
        return null;
    }

    @Override
    public TipoSolicitud getById(Integer integer) {
        return null;
    }

    @Override
    public TipoSolicitud getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends TipoSolicitud> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends TipoSolicitud> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends TipoSolicitud> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends TipoSolicitud> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends TipoSolicitud> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends TipoSolicitud> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends TipoSolicitud, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends TipoSolicitud> S save(S entity) {
        return null;
    }

    @Override
    public <S extends TipoSolicitud> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<TipoSolicitud> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<TipoSolicitud> findAll() {
        return List.of();
    }

    @Override
    public List<TipoSolicitud> findAllById(Iterable<Integer> integers) {
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
    public void delete(TipoSolicitud entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends TipoSolicitud> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<TipoSolicitud> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<TipoSolicitud> findAll(Pageable pageable) {
        return null;
    }
}
