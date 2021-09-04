package www.commerce.entities;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private boolean IsExecuted;
    private String address;
    private String city;
    private LocalDate date;
    private String email;
    private String first_name;
    private String last_name;
    private String phone_number;
    private short index;
    private Float total_price;

    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime modifiedAt;

    @OneToMany(fetch = FetchType.EAGER)
    private List<OrderItem> orderItems;


    public Order() {
        this.IsExecuted = false;
        this.date = LocalDate.now();
        this.orderItems = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   }
