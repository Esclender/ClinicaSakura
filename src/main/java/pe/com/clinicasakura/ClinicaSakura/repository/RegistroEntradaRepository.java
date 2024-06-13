package pe.com.clinicasakura.ClinicaSakura.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.com.clinicasakura.ClinicaSakura.model.RegistroEntradaEntity;

@Repository
public interface RegistroEntradaRepository extends JpaRepository<RegistroEntradaEntity, Long> {
  @Query("select r from RegistroEntradaEntity r where r.estado=true")
  Page<RegistroEntradaEntity> findAllCustom(Pageable pageable);
}
