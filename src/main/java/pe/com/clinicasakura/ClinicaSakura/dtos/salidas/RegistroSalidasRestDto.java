package pe.com.clinicasakura.ClinicaSakura.dtos.salidas;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegistroSalidasRestDto {
  private Date fecha;

  private Long codigoEmpleado;

  private Long codigoDestino;

  private int cantidadProducto;

  private Long codigoProducto;
}
