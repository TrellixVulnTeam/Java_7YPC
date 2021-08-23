package www.commerce.entities;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="products")
@Data
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 255, nullable = false)
    private String title;

    private String description;
    private String link;
    private float price;
    private float sale_price;
    private float discount;

    private boolean availability;

    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime modifiedAt;


    @ManyToMany(cascade=CascadeType.MERGE)
    @JoinTable(
            name="products_details",
            joinColumns={@JoinColumn(name="PRODUCT_ID", referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="DETAILS_ID", referencedColumnName="id")})

    private List<Product_Details> details;


    @ManyToMany(cascade=CascadeType.MERGE)
    @JoinTable(
            name="Filters",
            joinColumns={@JoinColumn(name="PRODUCT_ID", referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="FILTERS_ID", referencedColumnName="id")})
    private List<FilterValues> filters;


    @ManyToOne
    @JoinColumn(name="category_id", nullable = false)
    private Category category;

    @OneToMany(targetEntity=Product_Images.class, mappedBy="product", fetch = FetchType.LAZY)
    private List<Product_Images> images;


    public Product(String title) {
        this.title = title;
        this.details = new ArrayList<>();
        this.images = new ArrayList<>();
        this.filters = new ArrayList<>();
    }

    public List<FilterValues> getFilters() {
        return filters;
    }

    public void setFilters(List<FilterValues> filters) {
        this.filters = filters;
    }

    public Product() {
        this.details = new ArrayList<>();
        this.images = new ArrayList<>();
        this.filters = new ArrayList<>();
    }

    public Product(String title, String description, String link, float price, float sale_price, float discount, boolean availability, Category category) {
        this.title = title;
        this.description = description;
        this.link = link;
        this.price = price;
        this.sale_price = sale_price;
        this.discount = discount;
        this.availability = availability;
        this.category = category;

        this.details = new ArrayList<>();
        this.images = new ArrayList<>();
        this.filters = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getSale_price() {
        return sale_price;
    }

    public void setSale_price(float sale_price) {
        this.sale_price = sale_price;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }


    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public List<Product_Details> getDetails() {
        return details;
    }

    public void setDetails(List<Product_Details> details) {
        this.details = details;
    }



    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Product_Images> getImages() {
        return images;
    }

    public void setImages(List<Product_Images> images) {
        this.images = images;
    }


}
