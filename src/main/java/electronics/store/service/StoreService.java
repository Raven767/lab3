/*
 * this code is available under GNU GPL v3
 * https://www.gnu.org/licenses/gpl-3.0.en.html
 */

package electronics.store.service;

import electronics.store.rest.model.StoreDTO;
import java.util.List;

public interface StoreService {

    List<StoreDTO> listAll();

    void delete(Integer id);
    
    StoreDTO add(String name);
    
    StoreDTO findById(Integer id);

}
