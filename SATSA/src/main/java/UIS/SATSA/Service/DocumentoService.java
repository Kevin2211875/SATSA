package UIS.SATSA.Service;

import UIS.SATSA.Model.Documento;
import UIS.SATSA.Repository.DocumentoRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class DocumentoService implements DocumentoRepository {
    @Override
    public void flush() {

    }

    @Override
    public <S extends Documento> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Documento> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<Documento> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Documento getOne(Integer integer) {
        return null;
    }

    @Override
    public Documento getById(Integer integer) {
        return null;
    }

    @Override
    public Documento getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends Documento> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Documento> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends Documento> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends Documento> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Documento> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Documento> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Documento, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Documento> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Documento> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<Documento> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<Documento> findAll() {
        return List.of();
    }

    @Override
    public List<Documento> findAllById(Iterable<Integer> integers) {
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
    public void delete(Documento entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Documento> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Documento> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<Documento> findAll(Pageable pageable) {
        return null;
    }
}
