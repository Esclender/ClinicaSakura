
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
@Entity(name = "DistritoEntity")
@Table(name = "distrito")
public class DistritoEntity extends BaseEntity 
    implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Column(name = "nombre_distrito")
    @NotEmpty
    @Size(min = 2, max = 100, message = "El nombre del distrito tiene que estar entre {min} y {max} caracteres")
    private String nombre;  
}
