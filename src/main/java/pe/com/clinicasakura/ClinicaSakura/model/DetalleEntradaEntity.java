package pe.com.clinicasakura.ClinicaSakura.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
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
@EqualsAndHashCode(callSuper = false)
@Entity(name = "DetalleEntradaEntity")
@Table(name = "detalleentrada")
public class DetalleEntradaEntity
        implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codigo_detalle_entrada")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

    @NotEmpty
    @Column(name = "cantidad_producto")
    private int cantidadProducto;

    @NotEmpty
    @Column(name = "precio_producto")
    private double precioProducto;

    @ManyToOne
    @JoinColumn(name = "codigo_registro_entrada", nullable = false)
    private RegistroEntradaEntity codigoRegistroEntrada;

    @ManyToOne
    @JoinColumn(name = "codigo_producto", nullable = false)
    private ProductoEntity codigoProducto;

}
