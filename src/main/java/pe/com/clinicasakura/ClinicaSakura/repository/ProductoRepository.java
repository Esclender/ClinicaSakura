package pe.com.clinicasakura.ClinicaSakura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.com.clinicasakura.ClinicaSakura.model.ProductoEntity;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntity, Long> {

    @Query("SELECT p FROM ProductoEntity p WHERE p.cantidad_stock > 0")
    List<ProductoEntity> findAllCustom();
}
