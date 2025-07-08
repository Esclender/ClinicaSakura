
package pe.com.ferreteriamas.FerreteriaMas.service.base;

import java.util.List;
import pe.com.ferreteriamas.FerreteriaMas.model.base.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BaseService<T extends BaseEntity> {
    
    Page<T> findAll(Pageable pageable);
    
    Page<T> findAllCustom(Pageable pageable);

    T findById(Long id);

    T add(T t);

    T update(T t, Long id);

    T delete(Long id);
    
    T enable(Long id);
}