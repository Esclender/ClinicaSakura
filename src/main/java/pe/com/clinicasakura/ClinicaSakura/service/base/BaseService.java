package pe.com.clinicasakura.ClinicaSakura.service.base;


import java.util.List;
import java.util.Optional;

public interface BaseService<T> {

    List<T> findAll();

    List<T> findAllCustom();

    Optional<T> findById(Long id);

    T add(T t);

    T update(T t);

    T delete(T t);

    T enable(T t);

}