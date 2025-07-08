
package pe.com.ferreteriamas.FerreteriaMas.repository.base;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import pe.com.ferreteriamas.FerreteriaMas.model.base.BaseEntity;

@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity, ID extends Serializable>
        extends JpaRepository<T, ID> {

}
