package pe.com.clinicasakura.ClinicaSakura.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import pe.com.clinicasakura.ClinicaSakura.model.base.BaseEntity;


@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper=false)
@Entity(name = "DestinoEntity")
@Table(name = "destino")
public class DestinoEntity extends BaseEntity 
    implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codigo_destino")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;
    
    @Column(name = "nombre_destino")
    @NotEmpty
    @Size(min = 5, max = 40, message = "El nombre del destino tiene que estar entre {min} y {max} caracteres")
    private String nombre;
}
