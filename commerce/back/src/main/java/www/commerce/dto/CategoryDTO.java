package www.commerce.dto;

import lombok.Data;

@Data
public class CategoryDTO {

    private int id;
    private String name;
    private int catalogId;

    public CategoryDTO(int id, String name, int catalogId) {
        this.id = id;
        this.name = name;
        this.catalogId = catalogId;
    }

    public CategoryDTO(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
