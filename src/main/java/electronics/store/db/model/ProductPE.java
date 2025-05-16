/*
 * this code is available under GNU GPL v3
 * https://www.gnu.org/licenses/gpl-3.0.en.html
 */
package electronics.store.db.model;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "PRODUCT")
@Data
public class ProductPE implements Serializable {

    @ManyToOne
    @JoinColumn(name = "store_id")
    private StorePE store;
    public ProductPE() {
    }

    public ProductPE(Integer id, String name) {
        this.id = id;
        this.name = name;

    }

    @Id
    @Column(name = "productID")
    private Integer id;

    @Column(name = "productName")
    private String name;

    @Column(name = "productStoreID")
    private Integer school;
}
