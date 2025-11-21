package UIS.SATSA.Service;

import UIS.SATSA.Model.Grupo;
import UIS.SATSA.Repository.GrupoRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class GrupoService implements GrupoRepository {
    @Override
    public void flush() {

    }

    @Override
    public <S extends Grupo> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Grupo> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<Grupo> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Grupo getOne(Integer integer) {
        return null;
    }

    @Override
    public Grupo getById(Integer integer) {
        return null;
    }

    @Override
    public Grupo getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends Grupo> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Grupo> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends Grupo> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends Grupo> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Grupo> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Grupo> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Grupo, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Grupo> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Grupo> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<Grupo> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<Grupo> findAll() {
        return List.of();
    }

    @Override
    public List<Grupo> findAllById(Iterable<Integer> integers) {
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
    public void delete(Grupo entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Grupo> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Grupo> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<Grupo> findAll(Pageable pageable) {
        return null;
    }
}
