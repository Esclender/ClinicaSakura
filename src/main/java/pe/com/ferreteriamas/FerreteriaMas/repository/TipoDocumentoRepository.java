package pe.com.ferreteriamas.FerreteriaMas.repository;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.com.ferreteriamas.FerreteriaMas.model.TipoDocumentoEntity;
import pe.com.ferreteriamas.FerreteriaMas.repository.base.BaseRepository;

@Repository
public interface TipoDocumentoRepository extends BaseRepository<TipoDocumentoEntity, Long> {

    @Query("select td from TipoDocumentoEntity td where td.estado=true")
    Page<TipoDocumentoEntity> findAllCustom(Pageable pageable);
}
