
package pe.com.ferreteriamas.FerreteriaMas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import pe.com.ferreteriamas.FerreteriaMas.model.base.BaseEntity;


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
    
    @Column(name = "nombre_cargo")
    @NotEmpty
    @Size(min = 2, max = 60, message = "El nombre del cargo tiene que estar entre {min} y {max}")
    private String nombre;
}
