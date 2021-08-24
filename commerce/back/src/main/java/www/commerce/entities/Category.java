package www.commerce.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import www.commerce.repositories.CatalogRepository;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 255, nullable = false)
    private String name;

    @OneToMany(mappedBy = "category")
    @JsonBackReference(value="category")
    private List<Product> products;


    @OneToMany
    @JoinColumn(name="category_id")
    private List<FilterNames> filters;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="catalog_id")
    private Catalog catalog;


    public Category() {
        this.products = new ArrayList<>();
        this.filters = new ArrayList<>();
    }

    public Category(String name) {
        this.name = name;
        this.products = new ArrayList<>();
        this.filters = new ArrayList<>();
    }

    public Category(String name, int catalogId) {
        this.name = name;

        this.catalog = new Catalog();
        this.catalog.setId(catalogId);

        this.products = new ArrayList<>();
        this.filters = new ArrayList<>();
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

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }
}
