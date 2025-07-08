
package pe.com.ferreteriamas.FerreteriaMas.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;
import pe.com.ferreteriamas.FerreteriaMas.model.base.BaseEntity;


@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper=false)
@Entity(name = "ProductoEntity")
@Table(name = "productos")
public class ProductoEntity extends BaseEntity implements Serializable{
    private static final long serialVersion = 1L;
    
    @Column(name = "nompro")
    private String nombre;
    
    @Column(name = "stock")
    private int stock;
    
    @Column(name = "preciocompra")
    private double precioCompra;
    
    @Column(name = "precioventa")
    private double precioVenta;
    
    @ManyToOne
    @JoinColumn(name = "codcat", nullable = false)
    private CategoriaProductoEntity categoria;
}
