package pe.com.ferreteriamas.FerreteriaMas.repository;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.com.ferreteriamas.FerreteriaMas.model.ProveedorEntity;
import pe.com.ferreteriamas.FerreteriaMas.repository.base.BaseRepository;

@Repository
public interface ProveedorRepository extends BaseRepository<ProveedorEntity, Long> {

    @Query("select p from ProveedorEntity p where p.estado=true")
    Page<ProveedorEntity> findAllCustom(Pageable pageable);
}
