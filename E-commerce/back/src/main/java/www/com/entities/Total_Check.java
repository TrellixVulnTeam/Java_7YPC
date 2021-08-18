package www.com.entities;

import javax.persistence.*;

@Entity
@Table(name="totalChecks")
public class Total_Check {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private float total_price;
    private String comment;

    @OneToOne
    @JoinColumn(name="shipping_method_id", nullable=false, referencedColumnName = "id")
    private Shipping_Method shipping_method;

    @OneToOne
    @JoinColumn(name="payment_method_id", nullable=false, referencedColumnName = "id")
    private Payment_Method payment_method;

    @OneToOne
    @JoinColumn(name="order_id", nullable=false, referencedColumnName = "id")
    private Order order;


    public Total_Check() {
    }

    public Total_Check(float total_price, String comment, Shipping_Method shipping_method, Payment_Method payment_method, Order order) {
        this.total_price = total_price;
        this.comment = comment;
        this.shipping_method = shipping_method;
        this.payment_method = payment_method;
        this.order = order;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getTotal_price() {
        return total_price;
    }

    public void setTotal_price(float total_price) {
        this.total_price = total_price;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Shipping_Method getShipping_method() {
        return shipping_method;
    }

    public void setShipping_method(Shipping_Method shipping_method) {
        this.shipping_method = shipping_method;
    }

    public Payment_Method getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(Payment_Method payment_method) {
        this.payment_method = payment_method;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
