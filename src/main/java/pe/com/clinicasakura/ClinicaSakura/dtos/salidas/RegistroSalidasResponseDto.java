package pe.com.clinicasakura.ClinicaSakura.dtos.salidas;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import pe.com.clinicasakura.ClinicaSakura.model.DestinoEntity;
import pe.com.clinicasakura.ClinicaSakura.model.EmpleadoEntity;
import pe.com.clinicasakura.ClinicaSakura.model.ProductoEntity;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegistroSalidasResponseDto {
  private Long codigo;

  private Date fecha;

  private EmpleadoEntity empleado;

  private DestinoEntity destino;

  private int cantidadProducto;

  private ProductoEntity producto;
}
