package www.commerce.dto;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DetailValueDTO {
    private int id;
    private String name;
    private boolean IsDeleted;
    //private detailNameSlimDTO detailNameSlimDTO;
    private int detailNameId;

    public DetailValueDTO() {
    }
}
