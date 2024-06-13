package pe.com.clinicasakura.ClinicaSakura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.clinicasakura.ClinicaSakura.model.TipoDocumentoEntity;

@Repository
public interface TipoDocumentoRepository extends JpaRepository<TipoDocumentoEntity, Long> {
}
