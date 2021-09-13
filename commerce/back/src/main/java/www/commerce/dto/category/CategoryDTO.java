package www.commerce.dto.category;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.codehaus.jackson.annotate.JsonProperty;
import www.commerce.dto.filter.FilterNameDTO;
import www.commerce.dto.filter.FilterNameSlimDTO;
import www.commerce.dto.filter.FilterValueDTO;
import www.commerce.dto.product.ProductDTO;
import www.commerce.entities.Catalog;

import java.util.ArrayList;
import java.util.List;

public class CategoryDTO {

    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("catalogId")
    private int catalogId;

    private List<ProductDTO> products;
    private List<FilterNameDTO> filters;

    public CategoryDTO(int id, String name, int catalogId) {
        this.id = id;
        this.name = name;
        this.catalogId = catalogId;
        this.filters = new ArrayList<>();
        this.products = new ArrayList<>();
    }

    public CategoryDTO(int id, String name) {
        this.id = id;
        this.name = name;
        this.filters = new ArrayList<>();
        this.products = new ArrayList<>();
    }



    public CategoryDTO() {
        this.filters = new ArrayList<>();
        this.products = new ArrayList<>();
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

    public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }

    public List<FilterNameDTO> getFilters() {
        return filters;
    }

    public void setFilters(List<FilterNameDTO> filters) {
        this.filters = filters;
    }
}
