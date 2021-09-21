package www.commerce.dto.catalog;

import org.codehaus.jackson.annotate.JsonProperty;

public class ImageCatalogDTO {
    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("productId")
    private int catalogId;

    public ImageCatalogDTO( String name, int catalogId) {
        this.name = name;
        this.catalogId = catalogId;
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

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public ImageCatalogDTO() {
    }
}
