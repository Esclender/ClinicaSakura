package pe.com.clinicasakura.ClinicaSakura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.clinicasakura.ClinicaSakura.model.ProveedorEntity;

import java.util.List;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface ProveedorRepository extends JpaRepository<ProveedorEntity, Long> {

    // Método personalizado para consultar proveedores activos
    @Query("SELECT p FROM ProveedorEntity p WHERE p.estado = true")
    List<ProveedorEntity> findAllCustom();
}