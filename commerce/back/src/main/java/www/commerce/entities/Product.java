package www.commerce.entities;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="products")
@Data
@Getter
@Setter
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
            name="Details",
            joinColumns={@JoinColumn(name="PRODUCT_ID", referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="DETAILS_ID", referencedColumnName="id")})
    private List<DetailValue> details;


    @ManyToMany(cascade=CascadeType.MERGE)
    @JoinTable(
            name="Filters",
            joinColumns={@JoinColumn(name="PRODUCT_ID", referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="FILTERS_ID", referencedColumnName="id")})
    private List<FilterValue> filters;


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

    public List<FilterValue> getFilters() {
        return filters;
    }

    public void setFilters(List<FilterValue> filters) {
        this.filters = filters;
    }

    public Product() {
        this.details = new ArrayList<>();
        this.images = new ArrayList<>();
        this.filters = new ArrayList<>();
    }

    public Product(String title, String description, String link, float price, float sale_price, float discount, boolean availability, int categoryId) {
        this.title = title;
        this.description = description;
        this.link = link;
        this.price = price;
        this.sale_price = sale_price;
        this.discount = discount;
        this.availability = availability;

        this.category = new Category();
        this.category.setId(categoryId);

        this.details = new ArrayList<>();
        this.images = new ArrayList<>();
        this.filters = new ArrayList<>();
    }

    public Product(String title, String description, String link, float price, float sale_price, float discount, boolean availability, int categoryId,
                   List<DetailValue> details
            , List<FilterValue> filters
                   //List<Product_Images> images
    ) {
        this.title = title;
        this.description = description;
        this.link = link;
        this.price = price;
        this.sale_price = sale_price;
        this.discount = discount;
        this.availability = availability;

        this.category = new Category();
        this.category.setId(categoryId);

        this.details = details;
       this.images = new ArrayList<>();
        this.filters = filters;
    }



    public List<DetailValue> getDetails() {
        return details;
    }

    public void setDetails(List<DetailValue> details) {
        this.details = details;
    }

    public List<Product_Images> getImages() {
        return images;
    }

    public void setImages(List<Product_Images> images) {
        this.images = images;
    }
}
