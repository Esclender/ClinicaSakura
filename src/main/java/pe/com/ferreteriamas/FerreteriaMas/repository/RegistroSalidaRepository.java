package pe.com.ferreteriamas.FerreteriaMas.repository;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.com.ferreteriamas.FerreteriaMas.model.RegistroSalidaEntity;
import pe.com.ferreteriamas.FerreteriaMas.repository.base.BaseRepository;

@Repository
public interface RegistroSalidaRepository extends BaseRepository<RegistroSalidaEntity, Long> {

    @Query("select rs from RegistroSalidaEntity rs where rs.estado=true")
    Page<RegistroSalidaEntity> findAllCustom(Pageable pageable);
}
