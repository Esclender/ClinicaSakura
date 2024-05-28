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
@Entity(name = "TipoDocumentoEntity")
@Table(name = "tipodocumento")
public class TipoDocumentoEntity extends BaseEntity 
    implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codigo_tipo_documento")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

    @Column(name = "nombre_tipo_documento")
    @NotEmpty
    @Size(min = 2, max = 60, message = "El nombre tiene que estar entre {min} y {max} caracteres")
    private String nombre;
}
