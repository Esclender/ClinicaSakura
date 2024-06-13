
package pe.com.clinicasakura.ClinicaSakura.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
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
@Entity(name = "ProveedorEntity")
@Table(name = "proveedor")
public class ProveedorEntity extends BaseEntity 
    implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codigo_proveedor")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;
    
    
    @Column(name = "nombre_proveedor")
    @NotEmpty
    @Size(min = 10, max = 40, message = "El nombre tiene que estar entre {min} y {max} caracteres")
    private String nombre;
    
    
    @Column(name = "representante")
    @NotEmpty
    @Size(min = 5, max = 50, message = "El nombre del representante tiene que estar entre {min} y {max} caracteres")
    private String representante;
    
    @Column(name = "telefono")
    @Size(min = 7, max = 7, message = "El teléfono debe tener {max} caracteres")
    private String telefono;

    @Column(name = "celular")
    @Size(min = 9, max = 9, message = "El celular debe tener {max} caracteres")
    private String celular;
    
    @Column(name = "correo")
    @NotEmpty
    @Email(message = "El correo debe ser válido")
    private String correo;
    
    @Column(name = "direccion")
    @NotEmpty
    @Size(min = 5, max = 100, message = "La dirección tiene que estar entre {min} y {max} caracteres")
    private String direccion;
    
    @ManyToOne
    @JoinColumn(name = "codigo_distrito", nullable = false)
    private DistritoEntity distrito;
    
    
}
