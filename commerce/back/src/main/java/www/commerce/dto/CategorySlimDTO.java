package www.commerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.codehaus.jackson.annotate.JsonProperty;
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
}
