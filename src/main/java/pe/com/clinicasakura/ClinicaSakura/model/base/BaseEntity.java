package pe.com.clinicasakura.ClinicaSakura.model.base;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
@MappedSuperclass
public class BaseEntity {
    
    @Column(name = "estado")
    private boolean estado;
}

