
package pe.com.clinicasakura.ClinicaSakura.service.base;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BaseService<T> {

    List<T> findAll();

    Page<T> obtenerPaginas(Pageable pageable);

    Page<T> findAllCustom(Pageable pageable);

    Optional<T> findById(Long id);

    T add(T t);

    T update(T t);

    T delete(T t);

    T enable(T t);

}