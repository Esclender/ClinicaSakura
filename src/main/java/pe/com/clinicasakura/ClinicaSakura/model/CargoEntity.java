
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
@Entity(name = "CargoEntity")
@Table(name = "cargo")
public class CargoEntity extends BaseEntity 
    implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "codigo_cargo")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long codigo;
    
    @Column(name = "nombre_cargo")
    @NotEmpty
    @Size(min = 2, max = 60, message = "El nombre del cargo tiene que estar entre {min} y {max}")
    private String nombre;
}
