
package pe.com.ferreteriamas.FerreteriaMas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.com.ferreteriamas.FerreteriaMas.model.CredencialesEntity;
import pe.com.ferreteriamas.FerreteriaMas.repository.CredencialesRepository;
import pe.com.ferreteriamas.FerreteriaMas.service.CredencialesService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CredencialesServiceImp implements CredencialesService {

    @Autowired
    private CredencialesRepository credencialesRepository;

    // UserDetailsService implementation for Spring Security
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CredencialesEntity credenciales = credencialesRepository.findByUsuario(username);

        if (credenciales == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + credenciales.getRol()));

        return new User(credenciales.getUsuario(), credenciales.getClave(), authorities);
    }

    @Override
    public CredencialesEntity findByUsuario(String username) {
        return credencialesRepository.findByUsuario(username);
    }

    // BaseService implementation methods
    @Override
    public Page<CredencialesEntity> findAll(Pageable pageable) {
        return credencialesRepository.findAll(pageable);
    }

    @Override
    public Page<CredencialesEntity> findAllCustom(Pageable pageable) {
        // Use the existing method from repository
        return credencialesRepository.findAllCustom(pageable);
    }

    @Override
    public CredencialesEntity findById(Long id) {
        return credencialesRepository.findById(id).orElse(null);
    }

    @Override
    public CredencialesEntity add(CredencialesEntity credenciales) {
        return credencialesRepository.save(credenciales);
    }

    @Override
    public CredencialesEntity update(CredencialesEntity credenciales, Long id) {
        if (credencialesRepository.existsById(id)) {
            credenciales.setCodigo(id);
            return credencialesRepository.save(credenciales);
        }
        return null;
    }

    @Override
    public CredencialesEntity delete(Long id) {
        CredencialesEntity credenciales = findById(id);
        if (credenciales != null) {
            credenciales.setEstado(false); // Soft delete - mark as inactive
            return credencialesRepository.save(credenciales);
        }
        return null;
    }

    @Override
    public CredencialesEntity enable(Long id) {
        CredencialesEntity credenciales = findById(id);
        if (credenciales != null) {
            credenciales.setEstado(true); // Enable - mark as active
            return credencialesRepository.save(credenciales);
        }
        return null;
    }
}
