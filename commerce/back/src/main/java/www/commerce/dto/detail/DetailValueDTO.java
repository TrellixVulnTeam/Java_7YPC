package www.commerce.dto.detail;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.Setter;
import org.codehaus.jackson.annotate.JsonProperty;

@Getter
@Setter
@AllArgsConstructor
public class DetailValueDTO {
    private int id;
    private String name;
    private boolean isDeleted;
    @JsonProperty("detailNameId")
    private int detailNameId;

    public DetailValueDTO() {
    }

    public DetailValueDTO(String name, boolean isDeleted, int detailNameId) {
        this.name = name;
        this.isDeleted = isDeleted;
        this.detailNameId = detailNameId;
    }

    public DetailValueDTO(String name, int detailNameId) {
        this.name = name;
        this.detailNameId = detailNameId;
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
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public int getDetailNameId() {
        return detailNameId;
    }

    public void setDetailNameId(int detailNameId) {
        this.detailNameId = detailNameId;
    }
}
