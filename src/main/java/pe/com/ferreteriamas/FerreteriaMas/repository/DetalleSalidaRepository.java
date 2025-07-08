package pe.com.ferreteriamas.FerreteriaMas.repository;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.com.ferreteriamas.FerreteriaMas.model.DetalleSalidaEntity;
import pe.com.ferreteriamas.FerreteriaMas.repository.base.BaseRepository;

@Repository
public interface DetalleSalidaRepository extends BaseRepository<DetalleSalidaEntity, Long> {

    @Query("select ds from DetalleSalidaEntity ds where ds.estado=true")
    Page<DetalleSalidaEntity> findAllCustom(Pageable pageable);
}
