package pe.com.clinicasakura.ClinicaSakura.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.com.clinicasakura.ClinicaSakura.model.DetalleEntradaEntity;
import pe.com.clinicasakura.ClinicaSakura.repository.base.BaseRepository;

@Repository
public interface DetalleEntradaRepository extends BaseRepository<DetalleEntradaEntity, Long> {

  @Query("SELECT de FROM DetalleEntradaEntity de JOIN de.codigoRegistroEntrada re WHERE re.estado = true")
  Page<DetalleEntradaEntity> findAllCustom(Pageable pageable);
}
