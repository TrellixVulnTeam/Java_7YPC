package www.commerce.entities;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="catalog_images")
public class Catalog_Images {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(mappedBy = "image")
    private Catalog catalog;

    private String name;


    public Catalog_Images(Catalog catalog, String name) {
        this.catalog = catalog;
        this.name = name;
    }

    public Catalog_Images() {
    }

    public Catalog_Images(String name,  int catalogID) {
        this.name = name;
        this.catalog = new Catalog();
        this.catalog.setId(catalogID);
    }


    public Catalog_Images(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
