package pe.com.ferreteriamas.FerreteriaMas.repository;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.com.ferreteriamas.FerreteriaMas.model.DestinoEntity;
import pe.com.ferreteriamas.FerreteriaMas.repository.base.BaseRepository;

@Repository
public interface DestinoRepository extends BaseRepository<DestinoEntity, Long> {

    @Query("select d from DestinoEntity d where d.estado=true")
    Page<DestinoEntity> findAllCustom(Pageable pageable);
}
