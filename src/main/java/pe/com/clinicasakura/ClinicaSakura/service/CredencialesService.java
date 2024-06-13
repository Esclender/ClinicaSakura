package pe.com.clinicasakura.ClinicaSakura.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import pe.com.clinicasakura.ClinicaSakura.model.CredencialesEntity;
import pe.com.clinicasakura.ClinicaSakura.service.base.BaseService;

public interface CredencialesService extends BaseService<CredencialesEntity> {
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException ;
}
