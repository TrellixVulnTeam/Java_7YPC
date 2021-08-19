package www.commerce.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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

    @ManyToMany(mappedBy = "categories")
    @JsonBackReference
    private List<Brand> brands;

    @ManyToOne //(fetch = FetchType.LAZY)
    @JoinColumn(name="catalog_id", referencedColumnName="id",nullable = false)
    @JsonBackReference
    private Catalog catalog;


    public Category() {
        this.products = new ArrayList<>();
        this.brands = new ArrayList<>();
    }

    public Category(String name) {
        this.name = name;
        this.products = new ArrayList<>();
        this.brands = new ArrayList<>();
    }

    public Category(String name, Catalog catalog) {
        this.name = name;
        this.catalog = catalog;
        this.products = new ArrayList<>();
        this.brands = new ArrayList<>();
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

    public List<Brand> getBrands() {
        return brands;
    }

    public void setBrands(List<Brand> brands) {
        this.brands = brands;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }
}
