package pe.com.clinicasakura.ClinicaSakura.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.com.clinicasakura.ClinicaSakura.model.EmpleadoEntity;

@Repository
public interface EmpleadoRepository extends JpaRepository<EmpleadoEntity, Long> {
  @Query("select e from EmpleadoEntity e where e.estado=true")
  Page<EmpleadoEntity> findAllCustom(Pageable pageable);
}
