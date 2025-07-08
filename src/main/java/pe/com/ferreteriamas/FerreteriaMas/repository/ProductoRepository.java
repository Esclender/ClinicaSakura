
package pe.com.ferreteriamas.FerreteriaMas.repository;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.com.ferreteriamas.FerreteriaMas.model.ProductoEntity;
import pe.com.ferreteriamas.FerreteriaMas.repository.base.BaseRepository;

@Repository
public interface ProductoRepository extends BaseRepository<ProductoEntity, Long> {

    @Query("select p from ProductoEntity p where p.estado=true")
    Page<ProductoEntity> findAllCustom(Pageable pageable);

}
