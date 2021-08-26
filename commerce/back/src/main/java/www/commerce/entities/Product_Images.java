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
    @JoinColumn(name="product_id") //nullable=false)
    private Product product;

    private String name;


    public Product_Images(Product product, String name) {
        this.product = product;
        this.name = name;
    }

    public Product_Images() {
    }

    public Product_Images(String name,  int productID) {
        this.name = name;
        this.product = new Product();
        this.product.setId(productID);
    }


    public Product_Images(String name) {
        this.name = name;
    }
}
