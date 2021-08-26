package www.commerce.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="products_images")
public class Product_Images {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="product_id", nullable=false)
    private Product product;

    private String image;


    public Product_Images(Product product, String image) {
        this.product = product;
        this.image = image;
    }

    public Product_Images() {
    }

}
