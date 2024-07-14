package pe.com.clinicasakura.ClinicaSakura.dtos.entradas;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegistroEntradaRestDto {
  private Date fecha;

  private Long codigoProveedor;

  private Long codigoEmpleado;

  private int cantidadProducto;

  private double precioProducto;

  private Long codigoProducto;
}
