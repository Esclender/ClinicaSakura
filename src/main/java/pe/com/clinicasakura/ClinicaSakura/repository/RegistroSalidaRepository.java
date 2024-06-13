package pe.com.clinicasakura.ClinicaSakura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.clinicasakura.ClinicaSakura.model.RegistroSalidaEntity;

@Repository
public interface RegistroSalidaRepository extends JpaRepository<RegistroSalidaEntity, Long> {
}
