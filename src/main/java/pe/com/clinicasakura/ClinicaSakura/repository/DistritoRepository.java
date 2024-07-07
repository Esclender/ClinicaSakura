package pe.com.clinicasakura.ClinicaSakura.repository;


import org.springframework.stereotype.Repository;
import pe.com.clinicasakura.ClinicaSakura.model.DistritoEntity;
import pe.com.clinicasakura.ClinicaSakura.repository.base.BaseRepository;

@Repository
public interface DistritoRepository extends BaseRepository<DistritoEntity, Long>{

    // Aquí puedes definir métodos personalizados si los necesitas
}
