package pe.com.clinicasakura.ClinicaSakura.model.security;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "UserCredentials")
@Table(name = "credencialesaccesso")
public class UserCredentials {

  @Id
  @Column(name = "codigo_credenciales")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "username")
  private String username;

  @Column(name = "nombre_usuario")
  private String name;

  @Column(name = "password")
  private String password;

  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinTable(name = "rolesusuarios", joinColumns = @JoinColumn(name = "codigo_credenciales"), inverseJoinColumns = @JoinColumn(name = "codigo_rol"))
  private Set<SecurityRol> roles = new HashSet<>();

  @Column(name = "estado")
  private boolean enable;

}
