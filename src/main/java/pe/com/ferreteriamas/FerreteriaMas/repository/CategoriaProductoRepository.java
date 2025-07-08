
package pe.com.ferreteriamas.FerreteriaMas.repository;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.com.ferreteriamas.FerreteriaMas.model.CategoriaProductoEntity;
import pe.com.ferreteriamas.FerreteriaMas.repository.base.BaseRepository;

@Repository
public interface CategoriaProductoRepository extends BaseRepository<CategoriaProductoEntity, Long> {

    @Query("select cp from CategoriaProductoEntity cp where cp.estado=true")
    Page<CategoriaProductoEntity> findAllCustom(Pageable pageable);
}