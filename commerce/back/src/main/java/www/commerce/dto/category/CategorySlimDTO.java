package www.commerce.dto.category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.codehaus.jackson.annotate.JsonProperty;
import www.commerce.entities.Category;

@Setter
@Getter
@AllArgsConstructor
public class CategorySlimDTO {
    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("catalogId")
    private int catalogId;

    public CategorySlimDTO( String name, int catalogId) {
        this.name = name;
        this.catalogId = catalogId;
    }

    public CategorySlimDTO() {
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

    public int getCatalogId() {
        return catalogId;
    }

}
