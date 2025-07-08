package pe.com.ferreteriamas.FerreteriaMas.model;

import jakarta.persistence.*;
import java.io.Serializable;
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
@Entity(name = "DetalleEntradaEntity")
@Table(name = "detalleentrada")
public class DetalleEntradaEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "codprod", nullable = false)
    private ProductoEntity producto;
    
    @ManyToOne
    @JoinColumn(name = "codregent", nullable = false)
    private RegistroEntradaEntity registroEntrada;
    
    @Column(name = "precio")
    private double precio;
    
    @Column(name = "cantidad")
    private int cantidad;
}
