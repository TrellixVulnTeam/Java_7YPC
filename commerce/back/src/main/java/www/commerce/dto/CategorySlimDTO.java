package www.commerce.dto;

import lombok.Data;
import org.codehaus.jackson.annotate.JsonProperty;
@Data
public class CategorySlimDTO {
    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("catalogId")
    private int catalogId;

    public CategorySlimDTO(int id, String name, int catalogId) {
        this.id = id;
        this.name = name;
        this.catalogId = catalogId;
    }

    public CategorySlimDTO() {
    }
}
