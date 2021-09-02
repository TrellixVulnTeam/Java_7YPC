package www.commerce.dto;

import lombok.Data;
import org.codehaus.jackson.annotate.JsonProperty;

@Data
public class CatalogSlimDTO {

    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;

    public CatalogSlimDTO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public CatalogSlimDTO() {
    }
}
