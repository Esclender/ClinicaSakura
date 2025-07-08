package pe.com.ferreteriamas.FerreteriaMas.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import pe.com.ferreteriamas.FerreteriaMas.model.CredencialesEntity;
import pe.com.ferreteriamas.FerreteriaMas.repository.base.BaseRepository;


public interface CredencialesRepository extends BaseRepository<CredencialesEntity, Long> {
    
    @Query("select c from CredencialesEntity c where c.estado=true")
    Page<CredencialesEntity> findAllCustom(Pageable pageable);
    
    CredencialesEntity findByUsuario(String username);
    
}
