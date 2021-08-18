package www.com.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="brand")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 255, nullable = false)
    private String name;

    @OneToMany(mappedBy = "id")//, fetch = FetchType.LAZY)
    //@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JsonBackReference(value="brand")
    private List<Product> products;

    @ManyToMany(cascade=CascadeType.MERGE)
    @JoinTable(
            name="brand_category",
                joinColumns={@JoinColumn(name="BRAND_ID", referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="CATEGORY_ID", referencedColumnName="id")})
    @JsonBackReference
    private List<Category> categories;

    public Brand() {
        this.categories = new ArrayList<>();
        this.products = new ArrayList<>();
    }

    public Brand(String name) {
        this.name = name;
        this.products = new ArrayList<>();
        this.categories = new ArrayList<>();
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

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
