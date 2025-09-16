package UIS.SATSA.Service;

import UIS.SATSA.Model.Solicitud;
import UIS.SATSA.Repository.SolicitudReposittory;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class SolicitudService implements SolicitudReposittory {
    @Override
    public void flush() {

    }

    @Override
    public <S extends Solicitud> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Solicitud> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<Solicitud> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Solicitud getOne(Integer integer) {
        return null;
    }

    @Override
    public Solicitud getById(Integer integer) {
        return null;
    }

    @Override
    public Solicitud getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends Solicitud> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Solicitud> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends Solicitud> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends Solicitud> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Solicitud> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Solicitud> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Solicitud, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Solicitud> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Solicitud> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<Solicitud> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<Solicitud> findAll() {
        return List.of();
    }

    @Override
    public List<Solicitud> findAllById(Iterable<Integer> integers) {
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
    public void delete(Solicitud entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Solicitud> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Solicitud> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<Solicitud> findAll(Pageable pageable) {
        return null;
    }
}
