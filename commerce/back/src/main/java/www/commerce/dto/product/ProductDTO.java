package www.commerce.dto.product;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import www.commerce.dto.category.CategorySlimDTO;
import www.commerce.dto.detail.DetailValueDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class , property = "id")
public class ProductDTO {
    private int id;
    private String title;
    private String description;
    private String link;
    private float price;
    private float sale_price;
    private float discount;
    private boolean availability;

    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;


    private List<DetailValueDTO> details;

    private CategorySlimDTO category;

    private List<ImageProductDTO> images;


    public ProductDTO() {
        this.details = new ArrayList<>();
        this.images = new ArrayList<>();
    }

    public ProductDTO(String title) {
        this.title = title;
        this.details = new ArrayList<>();
        this.images = new ArrayList<>();
    }

}
