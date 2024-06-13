
package pe.com.clinicasakura.ClinicaSakura.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import pe.com.clinicasakura.ClinicaSakura.model.ProductoEntity;
import pe.com.clinicasakura.ClinicaSakura.repository.base.BaseRepository;

public interface ProductoRepository extends BaseRepository<ProductoEntity, Long> {

    @Query("select p from ProductoEntity p where p.estado=true")
    Page<ProductoEntity> findAllCustom(Pageable pageable);

}
