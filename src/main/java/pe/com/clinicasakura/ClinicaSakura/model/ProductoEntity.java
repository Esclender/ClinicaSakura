
package pe.com.clinicasakura.ClinicaSakura.model;


import com.fasterxml.jackson.annotation.JsonFormat;
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
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;
import pe.com.clinicasakura.ClinicaSakura.model.base.BaseEntity;


@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper=false)
@Entity(name = "ProductoEntity")
@Table(name = "producto")
public class ProductoEntity extends BaseEntity implements Serializable{
    private static final long serialVersion = 1L;
    
    @Id
    @Column(name = "codigo_producto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;
    
    @NotEmpty
    @Size(min = 5, max = 60, message = "El nombre del producto  tiene que estar entre {min} y {max}")
    @Column(name = "nombre_producto")
    private String nombre;
    
    @NotEmpty
    @Size(min = 10, max = 200, message = "La descripcion del producto  tiene que estar entre {min} y {max}")
    @Column(name = "descripcion")
    private String descripcion;
    
    @NotEmpty
    @Column(name = "cantidad_stock")
    private int cantidadStock ;
    
    @NotEmpty
    @Column(name = "fecha_caducidad")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date fechaCaducidad;
    
    @ManyToOne
    @JoinColumn(name = "codigo_categoria_producto", nullable = false)
    private CategoriaProductoEntity categoriaProducto;
}
