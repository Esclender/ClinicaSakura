
package pe.com.clinicasakura.ClinicaSakura.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import pe.com.clinicasakura.ClinicaSakura.model.CategoriaProductoEntity;
import pe.com.clinicasakura.ClinicaSakura.repository.base.BaseRepository;


public interface CategoriaProductoRepository extends BaseRepository<CategoriaProductoEntity, Long>{
    
     @Query("select c from CategoriaProductoEntity c where c.estado=true")
    List<CategoriaProductoEntity> findAllCustom();

}