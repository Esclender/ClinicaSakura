
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
@Entity(name = "ProveedorEntity")
@Table(name = "proveedores")
public class ProveedorEntity extends BaseEntity {

    @Column(name = "ruc")
    private String ruc;
    
    @Column(name = "razonsocial")
    private String razonSocial;
    
    @Column(name = "direccion")
    private String direccion;
    
    @Column(name = "telefono")
    private String telefono;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "contacto")
    private String contacto;
    
    @Column(name = "sitioweb")
    private String sitioWeb;
    
    @ManyToOne
    @JoinColumn(name = "coddistrito", nullable = false)
    private DistritoEntity distrito;
}
