package www.com.entities;

import javax.persistence.*;

@Entity
@Table(name="shipMethod")
public class Shipping_Method {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String type;
    private String city;
    private String branches;

    public Shipping_Method() {
    }

    public Shipping_Method(String name, String type, String city, String branches) {
        this.name = name;
        this.type = type;
        this.city = city;
        this.branches = branches;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBranches() {
        return branches;
    }

    public void setBranches(String branches) {
        this.branches = branches;
    }
}
