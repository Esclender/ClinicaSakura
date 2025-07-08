/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.ferreteriamas.FerreteriaMas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

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
@EqualsAndHashCode(callSuper = false)
@Entity(name = "EmpleadoEntity")
@Table(name = "empleados")
public class EmpleadoEntity extends BaseEntity {

    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "apepat")
    private String apellidoPaterno;
    
    @Column(name = "apemat")
    private String apellidoMaterno;
    
    @Column(name = "fechanac")
    private String fechaNacimiento;
    
    @Column(name = "direccion")
    private String direccion;
    
    @Column(name = "telefono")
    private String telefono;
    
    @Column(name = "nrodocumento")
    private String numeroDocumento;
    
    @Column(name = "sexo")
    private String sexo;
    
    @ManyToOne
    @JoinColumn(name = "codcargo", nullable = false)
    private CargoEntity codcargo;
    
    @ManyToOne
    @JoinColumn(name = "coddistrito", nullable = false)
    private DistritoEntity coddistrito;
    
    @ManyToOne
    @JoinColumn(name = "codtipdoc", nullable = false)
    private TipoDocumentoEntity codtipdoc;
}
