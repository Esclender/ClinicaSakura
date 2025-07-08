package pe.com.ferreteriamas.FerreteriaMas.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import pe.com.ferreteriamas.FerreteriaMas.model.CredencialesEntity;
import pe.com.ferreteriamas.FerreteriaMas.service.base.BaseService;

public interface CredencialesService extends BaseService<CredencialesEntity>, UserDetailsService {

    public CredencialesEntity findByUsuario(String username);
}
