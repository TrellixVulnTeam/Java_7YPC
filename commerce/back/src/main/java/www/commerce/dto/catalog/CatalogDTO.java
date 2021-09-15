package www.commerce.dto.catalog;

import lombok.Data;
import org.codehaus.jackson.annotate.JsonProperty;
import www.commerce.dto.category.CategoryDTO;
import www.commerce.dto.category.CategorySlimDTO;

import java.util.ArrayList;
import java.util.List;

@Data
public class CatalogDTO {

    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("categories")
    private List<CategorySlimDTO> categories;


    public CatalogDTO(int id, String name) {
        this.id = id;
        this.name = name;
        this.categories = new ArrayList<>();

    }

    public CatalogDTO(int id, String name, List<CategorySlimDTO> categories) {
        this.id = id;
        this.name = name;
        this.categories = categories;
    }

    public CatalogDTO() {
        this.categories = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
}
