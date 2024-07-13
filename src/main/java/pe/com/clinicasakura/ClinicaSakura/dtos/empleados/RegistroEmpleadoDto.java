package pe.com.clinicasakura.ClinicaSakura.dtos.empleados;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import pe.com.clinicasakura.ClinicaSakura.model.CargoEntity;
import pe.com.clinicasakura.ClinicaSakura.model.DistritoEntity;
import pe.com.clinicasakura.ClinicaSakura.model.EmpleadoEntity;
import pe.com.clinicasakura.ClinicaSakura.model.TipoDocumentoEntity;

@Data
@AllArgsConstructor
public class RegistroEmpleadoDto {
  private String nombre;
  private String apellidoPaterno;
  private String apellidoMaterno;
  private String documentoIdentidad;
  private long codigoTipoDocumento;
  private String correo;
  private String telefono;
  private String celular;
  private String sexo;
  private String direccion;
  private Date fechaNacimiento;
  private long codigoDistrito;
  private long codigoCargo;
  private boolean estado;

  public EmpleadoEntity ToEmpleadoEntity(CargoEntity cargoEntity, DistritoEntity distritoEntity,
      TipoDocumentoEntity tipoDocumentoEntity) {

    EmpleadoEntity entity = new EmpleadoEntity();
    entity.setNombre(nombre);
    entity.setApellidopaterno(apellidoPaterno);
    entity.setApellidomaterno(apellidoMaterno);
    entity.setNumerodocumento(documentoIdentidad);
    entity.setCorreo(correo);
    entity.setTelefono(telefono);
    entity.setCelular(celular);
    entity.setSexo(sexo);
    entity.setDireccion(direccion);
    entity.setFechanacimiento(fechaNacimiento);
    entity.setCargo(cargoEntity);
    entity.setDistrito(distritoEntity);
    entity.setTipodocumento(tipoDocumentoEntity);
    entity.setEstado(estado);
    return entity;

  }
}
