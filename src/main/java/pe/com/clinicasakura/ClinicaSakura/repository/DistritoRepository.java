package pe.com.clinicasakura.ClinicaSakura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.clinicasakura.ClinicaSakura.model.DistritoEntity;

@Repository
public interface DistritoRepository extends JpaRepository<DistritoEntity, Long> {

    // Aquí puedes definir métodos personalizados si los necesitas
}
