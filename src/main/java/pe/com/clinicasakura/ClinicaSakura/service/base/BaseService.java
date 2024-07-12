
package pe.com.clinicasakura.ClinicaSakura.service.base;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BaseService<T> {

    List<T> findAll();

    default Page<T> obtenerPaginas(Pageable pageable) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    default Page<T> findAllCustom(Pageable pageable) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    T findById(Long id);

    default T add(T t) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    default T update(T t) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    default T update(T t, Long id) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    default T delete(T t) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    default T delete(Long id) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    default T enable(T t) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    default T enable(Long id) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

}