package UIS.SATSA.Service;

import UIS.SATSA.Model.Historial;
import UIS.SATSA.Repository.HistorialRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class HistorialService implements HistorialRepository {
    @Override
    public void flush() {

    }

    @Override
    public <S extends Historial> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Historial> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<Historial> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Historial getOne(Integer integer) {
        return null;
    }

    @Override
    public Historial getById(Integer integer) {
        return null;
    }

    @Override
    public Historial getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends Historial> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Historial> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends Historial> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends Historial> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Historial> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Historial> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Historial, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Historial> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Historial> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<Historial> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<Historial> findAll() {
        return List.of();
    }

    @Override
    public List<Historial> findAllById(Iterable<Integer> integers) {
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
    public void delete(Historial entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Historial> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Historial> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<Historial> findAll(Pageable pageable) {
        return null;
    }
}
