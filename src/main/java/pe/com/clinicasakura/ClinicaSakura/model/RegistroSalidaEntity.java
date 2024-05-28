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
import java.io.Serializable;
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
@Entity(name = "RegistroSalidaEntity")
@Table(name = "registrosalida")
public class RegistroSalidaEntity extends BaseEntity 
    implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codigo_registro_salida")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;
    
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    
    @ManyToOne
    @JoinColumn(name = "codigo_destino", nullable = false)
    private DestinoEntity codigoDestino;
    
    @ManyToOne
    @JoinColumn(name = "codigo_empleado", nullable = false)
    private EmpleadoEntity codigoEmpleado;
}
