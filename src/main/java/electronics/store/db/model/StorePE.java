package electronics.store.db.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="STORE")
@Data
public class StorePE implements Serializable {

    private static final long serialVersionUID = 1L;

    public StorePE() {}
    public StorePE(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public StorePE(String name) {
        this.name = name;
    }

    @Id
    @Column(name = "storeID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(targetEntity = ProductPE.class, mappedBy = "store", fetch = FetchType.LAZY)
    private List<ProductPE> storesList;

    @Column(name = "storeName")
    private String name;
}
