package www.commerce.entities;

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
    @JoinColumn(name="order_id", nullable=false, referencedColumnName = "id")
    private Order order;


    public Total_Check() {
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


}
