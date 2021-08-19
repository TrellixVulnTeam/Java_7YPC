package www.commerce.entities;

import javax.persistence.*;

@Entity
@Table(name="payMethod")
public class Payment_Method {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    public Payment_Method() {
    }

    public Payment_Method(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
