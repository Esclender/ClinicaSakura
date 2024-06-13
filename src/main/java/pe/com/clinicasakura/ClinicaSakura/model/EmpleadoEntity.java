/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.clinicasakura.ClinicaSakura.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
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
@Entity(name = "EmpleadoEntity")
@Table(name = "empleado")
public class EmpleadoEntity extends BaseEntity
    implements Serializable{
   
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codigo_empleado")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

    @Column(name = "nombre")
    @NotEmpty
    @Size(min = 2, max = 50, message = "El nombre tiene que estar entre {min} y {max} caracteres")
    private String nombre;

     @Column(name = "apellido_paterno")
    @NotEmpty
    @Size(min = 2, max = 50, message = "El apellido paterno tiene que estar entre {min} y {max} caracteres")
    private String apellidopaterno;

    @Column(name = "apellido_materno")
    @NotEmpty
    @Size(min = 2, max = 50, message = "El apellido materno tiene que estar entre {min} y {max} caracteres")
    private String apellidomaterno;

    @Column(name = "documento_identidad")
    @NotEmpty
    @Size(min = 8, max = 15, message = "El número de documento tiene que estar entre {min} y {max} caracteres")
    private String numerodocumento;

    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechanacimiento;

    @Column(name = "direccion")
    @NotEmpty
    @Size(min = 5, max = 100, message = "La dirección tiene que estar entre {min} y {max} caracteres")
    private String direccion;

    @Column(name = "telefono")
    @Size(min=7, max = 7, message = "El teléfono debe tener {max} caracteres")
    private String telefono;

    @Column(name = "celular")
    @Size(min=9,max = 9, message = "El celular debe tener {max} caracteres")
    private String celular;

    @Column(name = "correo")
    @NotEmpty
    @Email(message = "El correo debe ser válido")
    private String correo;

    @Column(name = "sexo")
    @NotEmpty
    @Size(min = 1, max = 1, message = "El sexo debe ser 'M' o 'F'")
    private String sexo;
    
    @ManyToOne
    @JoinColumn(name = "codigo_tipo_documento", nullable = false)
    private TipoDocumentoEntity tipodocumento;

    @ManyToOne
    @JoinColumn(name = "codigo_distrito", nullable = false)
    private DistritoEntity distrito;

    @ManyToOne
    @JoinColumn(name = "codigo_cargo", nullable = false)
    private CargoEntity cargo;
}
