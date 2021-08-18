package www.com.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="productsInCart")
public class Product_In_Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int Quantity;

    @OneToOne
    @JoinColumn(name="product_id", nullable=false, referencedColumnName = "id")
    private Product product;

    @ManyToOne
    @JoinColumn(name="products")
    private Order order;


    public Product_In_Cart() {
    }

    public Product_In_Cart(int quantity, Product product, Order order) {
        Quantity = quantity;
        this.product = product;
        this.order = order;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
