package www.commerce.dto.detail;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class DetailNameDTO {
    private int id;
    private String name;
    private boolean isDeleted;
    private List<DetailValueDTO> values;

    public DetailNameDTO() {
    }
}
