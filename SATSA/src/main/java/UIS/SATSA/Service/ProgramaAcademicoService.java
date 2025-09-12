package UIS.SATSA.Service;

import UIS.SATSA.Model.ProgramaAcademico;
import UIS.SATSA.Repository.ProgramaAcademicoRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class ProgramaAcademicoService implements ProgramaAcademicoRepository {
    @Override
    public void flush() {

    }

    @Override
    public <S extends ProgramaAcademico> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends ProgramaAcademico> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<ProgramaAcademico> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public ProgramaAcademico getOne(Integer integer) {
        return null;
    }

    @Override
    public ProgramaAcademico getById(Integer integer) {
        return null;
    }

    @Override
    public ProgramaAcademico getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends ProgramaAcademico> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends ProgramaAcademico> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends ProgramaAcademico> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends ProgramaAcademico> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends ProgramaAcademico> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends ProgramaAcademico> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends ProgramaAcademico, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends ProgramaAcademico> S save(S entity) {
        return null;
    }

    @Override
    public <S extends ProgramaAcademico> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<ProgramaAcademico> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<ProgramaAcademico> findAll() {
        return List.of();
    }

    @Override
    public List<ProgramaAcademico> findAllById(Iterable<Integer> integers) {
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
    public void delete(ProgramaAcademico entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends ProgramaAcademico> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<ProgramaAcademico> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<ProgramaAcademico> findAll(Pageable pageable) {
        return null;
    }
}
