package pe.com.clinicasakura.ClinicaSakura.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import pe.com.clinicasakura.ClinicaSakura.model.CredencialesEntity;
import pe.com.clinicasakura.ClinicaSakura.repository.base.BaseRepository;


public interface CredencialesRepository extends BaseRepository<CredencialesEntity, Long> {
    @Query("select c from CredencialesEntity c where c.estado=true")
    List<CredencialesEntity> findAllCustom();
    
    CredencialesEntity findByUsuario(String usuario);
}
