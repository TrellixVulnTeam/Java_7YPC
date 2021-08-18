package www.commerce.entities;

import javax.persistence.*;

@Entity
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
