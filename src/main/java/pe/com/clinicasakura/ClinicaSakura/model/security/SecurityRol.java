package pe.com.clinicasakura.ClinicaSakura.model.security;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "SecurityRol")
@Table(name = "rolesseguridad")
public class SecurityRol {

  @Id
  @Column(name = "codigo_rol")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "nombre_rol")
  private String nombreRol;

  @Column(name = "estado")
  private boolean estado;

}
