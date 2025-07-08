package pe.com.ferreteriamas.FerreteriaMas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import pe.com.ferreteriamas.FerreteriaMas.model.base.BaseEntity;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@Entity(name = "CredencialesEntity")
@Table(name = "credenciales")
public class CredencialesEntity extends BaseEntity {
    @Column(name = "usuario")
    @NotEmpty
    @Size(min = 5, max = 50, message = "El usuario tiene que estar entre {min} y {max} caracteres")
    private String usuario;
    @Column(name = "clave")
    private String clave;
    @Column(name = "rol")
    private String rol;
    @OneToOne
    @JoinColumn(name = "codemp")
    private EmpleadoEntity codigoEmpleado;
}
