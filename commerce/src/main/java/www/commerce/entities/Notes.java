package www.commerce.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="notes")
public class Notes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 255, nullable = false)
    private String name;

//    @ManyToOne()
//    @JoinColumn(name="notes", insertable = false, updatable = false)
//    private Product product;

    @ManyToMany(mappedBy="notes")
    private List<Product> products;

    public Notes() {
        this.products = new ArrayList<>();
    }

    public Notes(String name) {
        this.name = name;
        this.products = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
