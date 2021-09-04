package www.commerce.entities;

import javax.persistence.*;

@Entity
@Table(name="order_item")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int amount;
    private int quantity;

    @OneToOne
    private Product product;
}
