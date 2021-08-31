package www.commerce.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import www.commerce.entities.DetailValue;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class DetailNameDTO {
    private int id;
    private String name;
    private boolean IsDeleted;
    private List<DetailValueDTO> values;

    public DetailNameDTO() {
    }
}
