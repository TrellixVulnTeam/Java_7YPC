package www.commerce.dto;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class FilterDTO {
    private int id;
    private String name;
    private boolean IsDeleted;
    private boolean IsAdmin;
    private LocalDateTime createdAt;
    private int FilterNameId;

    public FilterDTO() {
    }
}
