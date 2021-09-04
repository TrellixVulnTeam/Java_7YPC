package www.commerce.dto.catalog;

import lombok.Data;
import org.codehaus.jackson.annotate.JsonProperty;
import www.commerce.dto.category.CategoryDTO;

import java.util.List;

@Data
public class CatalogDTO {

    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("categories")
    private List<CategoryDTO> categories;


    public CatalogDTO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public CatalogDTO(int id, String name, List<CategoryDTO> categories) {
        this.id = id;
        this.name = name;
        this.categories = categories;
    }

    public CatalogDTO() {
    }
}
