package www.commerce.dto.detail;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DetailValueDTO {
    private int id;
    private String name;
    private boolean isDeleted;
    private int detailNameId;

    public DetailValueDTO() {
    }
}
