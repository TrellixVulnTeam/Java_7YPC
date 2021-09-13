package www.commerce.dto.filter;

import www.commerce.dto.category.CategorySlimDTO;

import java.util.ArrayList;
import java.util.List;

public class FilterNameDTO {
    private int id;
    private String name;
    private boolean IsDeleted;
    private boolean IsAdmin;
    private CategorySlimDTO categoryId;
    private List<FilterValueDTO> values;

    public FilterNameDTO() {
        this.values = new ArrayList<>();
    }

    public FilterNameDTO(String name, CategorySlimDTO categoryId, List<FilterValueDTO> values) {
        this.name = name;
        this.categoryId = categoryId;
        this.values = values;
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

    public boolean isDeleted() {
        return IsDeleted;
    }

    public void setDeleted(boolean deleted) {
        IsDeleted = deleted;
    }

    public boolean isAdmin() {
        return IsAdmin;
    }

    public void setAdmin(boolean admin) {
        IsAdmin = admin;
    }

    public CategorySlimDTO getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(CategorySlimDTO categoryId) {
        this.categoryId = categoryId;
    }

    public List<FilterValueDTO> getValues() {
        return values;
    }

    public void setValues(List<FilterValueDTO> values) {
        this.values = values;
    }
}
