package www.commerce.dto.product;


import lombok.Data;
import org.codehaus.jackson.annotate.JsonProperty;

@Data
public class ImageProductDTO {
    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("productId")
    private int productId;

    public ImageProductDTO( String name, int productId) {
        this.name = name;
        this.productId = productId;
    }

    public ImageProductDTO() {
    }

}
