package pe.com.clinicasakura.ClinicaSakura.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.com.clinicasakura.ClinicaSakura.model.DetalleSalidaEntity;

public interface DetalleSalidaRepository extends JpaRepository<DetalleSalidaEntity, Long> {
     @Query("select d from DetalleSalidaEntity d where d.estado=true")
     Page<DetalleSalidaEntity> findAllCustom(Pageable pageable);

}
