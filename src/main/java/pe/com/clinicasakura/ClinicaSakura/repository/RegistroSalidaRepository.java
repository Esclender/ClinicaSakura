package pe.com.clinicasakura.ClinicaSakura.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.com.clinicasakura.ClinicaSakura.model.RegistroSalidaEntity;

@Repository
public interface RegistroSalidaRepository extends JpaRepository<RegistroSalidaEntity, Long> {

  @Query("select r from RegistroSalidaEntity r where r.estado=true")
  Page<RegistroSalidaEntity> findAllCustom(Pageable pageable);

}
