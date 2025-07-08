package pe.com.ferreteriamas.FerreteriaMas.repository;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.com.ferreteriamas.FerreteriaMas.model.CargoEntity;
import pe.com.ferreteriamas.FerreteriaMas.repository.base.BaseRepository;

@Repository
public interface CargoRepository extends BaseRepository<CargoEntity, Long> {

    @Query("select c from CargoEntity c where c.estado=true")
    Page<CargoEntity> findAllCustom(Pageable pageable);
}
