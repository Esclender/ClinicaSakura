package pe.com.ferreteriamas.FerreteriaMas.repository;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.com.ferreteriamas.FerreteriaMas.model.RegistroEntradaEntity;
import pe.com.ferreteriamas.FerreteriaMas.repository.base.BaseRepository;

@Repository
public interface RegistroEntradaRepository extends BaseRepository<RegistroEntradaEntity, Long> {

    @Query("select re from RegistroEntradaEntity re where re.estado=true")
    Page<RegistroEntradaEntity> findAllCustom(Pageable pageable);
}
