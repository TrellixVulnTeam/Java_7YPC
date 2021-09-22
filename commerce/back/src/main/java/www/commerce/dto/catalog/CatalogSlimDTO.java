package www.commerce.dto.catalog;

import lombok.Data;
import org.codehaus.jackson.annotate.JsonProperty;

@Data
public class CatalogSlimDTO {

    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("image")
    private String image;

    public CatalogSlimDTO(int id, String name, String image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }

    public CatalogSlimDTO(int id, String name) {
        this.id = id;
        this.name = name;    }


    public CatalogSlimDTO() {
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

    public String getImage() {

        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
