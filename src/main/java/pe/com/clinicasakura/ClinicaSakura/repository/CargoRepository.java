package pe.com.clinicasakura.ClinicaSakura.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.com.clinicasakura.ClinicaSakura.model.CargoEntity;

@Repository
public interface CargoRepository extends JpaRepository<CargoEntity, Long> {
    @Query("select p from CargoEntity p where p.estado=true")
    Page<CargoEntity> findAllCustom(Pageable pageable);
}
