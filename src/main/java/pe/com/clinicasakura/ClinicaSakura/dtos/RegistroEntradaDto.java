package pe.com.clinicasakura.ClinicaSakura.dtos;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import pe.com.clinicasakura.ClinicaSakura.model.EmpleadoEntity;
import pe.com.clinicasakura.ClinicaSakura.model.ProductoEntity;
import pe.com.clinicasakura.ClinicaSakura.model.ProveedorEntity;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegistroEntradaDto {
    
    private ProveedorEntity proveedor;
    
    
    private EmpleadoEntity empleado;
    
    
    private int cantidadProducto;
    
    
    private double precioProducto;
    
    
    private ProductoEntity producto;

}
