package www.commerce.dto.filter;

import www.commerce.dto.category.CategorySlimDTO;
import java.util.List;

public class FilterNameDTO {
    private int id;
    private String name;
    private boolean IsDeleted;
    private boolean IsAdmin;
    private CategorySlimDTO categoryId;
    private List<FilterValueDTO> values;
}
