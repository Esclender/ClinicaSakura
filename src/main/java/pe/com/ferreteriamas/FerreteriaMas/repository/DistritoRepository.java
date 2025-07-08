package pe.com.ferreteriamas.FerreteriaMas.repository;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.com.ferreteriamas.FerreteriaMas.model.DistritoEntity;
import pe.com.ferreteriamas.FerreteriaMas.repository.base.BaseRepository;

@Repository
public interface DistritoRepository extends BaseRepository<DistritoEntity, Long> {

    @Query("select d from DistritoEntity d where d.estado=true")
    Page<DistritoEntity> findAllCustom(Pageable pageable);
}
