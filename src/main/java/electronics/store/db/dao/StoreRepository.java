/*
 * this code is available under GNU GPL v3
 * https://www.gnu.org/licenses/gpl-3.0.en.html
 */
package electronics.store.db.dao;

import electronics.store.db.model.StorePE;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface StoreRepository extends CrudRepository<StorePE, Integer> {

    public Optional<StorePE> findById(Integer number);

    public List<StorePE> findAll();
}
