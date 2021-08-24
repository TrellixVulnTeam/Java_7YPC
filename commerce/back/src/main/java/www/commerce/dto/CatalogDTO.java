package www.commerce.dto;

import lombok.Data;
import www.commerce.entities.Category;

import java.util.List;

@Data
public class CatalogDTO {

    private int id;
    private String name;
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
}
