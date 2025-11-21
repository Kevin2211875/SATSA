package UIS.SATSA.Service;

import UIS.SATSA.Model.UsuarioRol;
import UIS.SATSA.Repository.UsuarioRolRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class UsuarioService implements UsuarioRolRepository {
    @Override
    public void flush() {

    }

    @Override
    public <S extends UsuarioRol> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends UsuarioRol> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<UsuarioRol> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public UsuarioRol getOne(Integer integer) {
        return null;
    }

    @Override
    public UsuarioRol getById(Integer integer) {
        return null;
    }

    @Override
    public UsuarioRol getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends UsuarioRol> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends UsuarioRol> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends UsuarioRol> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends UsuarioRol> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends UsuarioRol> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends UsuarioRol> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends UsuarioRol, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends UsuarioRol> S save(S entity) {
        return null;
    }

    @Override
    public <S extends UsuarioRol> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<UsuarioRol> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<UsuarioRol> findAll() {
        return List.of();
    }

    @Override
    public List<UsuarioRol> findAllById(Iterable<Integer> integers) {
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
    public void delete(UsuarioRol entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends UsuarioRol> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<UsuarioRol> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<UsuarioRol> findAll(Pageable pageable) {
        return null;
    }
}
