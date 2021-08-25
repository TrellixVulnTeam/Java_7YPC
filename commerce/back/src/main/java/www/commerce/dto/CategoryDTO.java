package www.commerce.dto;

import lombok.Data;
import org.codehaus.jackson.annotate.JsonProperty;
import www.commerce.entities.FilterNames;

import java.util.List;

@Data
public class CategoryDTO {

    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("catalogId")
    private int catalogId;

    private List<ProductDTO> products;
    private List<FilterDTO> filters;

    public CategoryDTO(int id, String name, int catalogId) {
        this.id = id;
        this.name = name;
        this.catalogId = catalogId;
    }

    public CategoryDTO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public CategoryDTO() {
    }
}
