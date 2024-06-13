package pe.com.clinicasakura.ClinicaSakura.model;

import jakarta.persistence.*;
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
@Entity(name = "CredencialesEntity")
@Table(name = "credencialesaccesso")
public class CredencialesEntity extends BaseEntity
        implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codigo_credenciales")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

    @Column(name = "usuario")
    @NotEmpty
    @Size(min = 5, max = 50, message = "El usuario tiene que estar entre {min} y {max} caracteres")
    private String usuario;

    @Column(name = "clave")
    @NotEmpty
    @Size( max = 250, message = "Clave supera el maximo de {max} caracteres")
    private String clave;

    @ManyToOne
    @JoinColumn(name = "codigo_empleado", nullable = false)
    private EmpleadoEntity codigoEmpleado;

}
