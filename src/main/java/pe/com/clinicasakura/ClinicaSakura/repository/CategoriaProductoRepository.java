package pe.com.clinicasakura.ClinicaSakura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.clinicasakura.ClinicaSakura.model.CategoriaProductoEntity;

@Repository
public interface CategoriaProductoRepository extends JpaRepository<CategoriaProductoEntity, Long> {
    // Puedes agregar consultas personalizadas aquí si es necesario
}
