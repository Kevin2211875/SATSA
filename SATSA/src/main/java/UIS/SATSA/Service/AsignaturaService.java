package UIS.SATSA.Service;

import UIS.SATSA.Model.Asignatura;
import UIS.SATSA.Repository.AsignaturaRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class AsignaturaService implements AsignaturaRepository {
    @Override
    public void flush() {

    }

    @Override
    public <S extends Asignatura> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Asignatura> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<Asignatura> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Asignatura getOne(Integer integer) {
        return null;
    }

    @Override
    public Asignatura getById(Integer integer) {
        return null;
    }

    @Override
    public Asignatura getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends Asignatura> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Asignatura> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends Asignatura> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends Asignatura> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Asignatura> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Asignatura> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Asignatura, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Asignatura> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Asignatura> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<Asignatura> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<Asignatura> findAll() {
        return List.of();
    }

    @Override
    public List<Asignatura> findAllById(Iterable<Integer> integers) {
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
    public void delete(Asignatura entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Asignatura> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Asignatura> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<Asignatura> findAll(Pageable pageable) {
        return null;
    }
}
