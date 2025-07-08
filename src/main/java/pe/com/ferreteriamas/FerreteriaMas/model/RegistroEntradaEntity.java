package pe.com.ferreteriamas.FerreteriaMas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
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
@Entity(name = "RegistroEntradaEntity")
@Table(name = "registroentrada")
public class RegistroEntradaEntity extends BaseEntity
    implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    
    @ManyToOne
    @JoinColumn(name = "codprov", nullable = false)
    private ProveedorEntity codigoProveedor;
    
    @ManyToOne
    @JoinColumn(name = "codemp", nullable = false)
    private EmpleadoEntity codigoEmpleado;
}
