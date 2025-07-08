package pe.com.ferreteriamas.FerreteriaMas.repository;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.com.ferreteriamas.FerreteriaMas.model.DetalleEntradaEntity;
import pe.com.ferreteriamas.FerreteriaMas.repository.base.BaseRepository;

@Repository
public interface DetalleEntradaRepository extends BaseRepository<DetalleEntradaEntity, Long> {

    @Query("select de from DetalleEntradaEntity de where de.estado=true")
    Page<DetalleEntradaEntity> findAllCustom(Pageable pageable);
}
