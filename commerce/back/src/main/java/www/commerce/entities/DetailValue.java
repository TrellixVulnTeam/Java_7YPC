package www.commerce.entities;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@ToString
@Table(name="DetailValues")
public class DetailValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 255, nullable = false)
    private String name;

    private boolean isDeleted;

    private int detailName_id;

    public DetailValue() {
    }

    public DetailValue(String name, boolean isDeleted, int detailNameId) {
        this.name = name;
        this.isDeleted = isDeleted;
        this.detailName_id = detailNameId;
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
        return detailName_id;
    }

    public void setDetailNameId(int detailNameId) {
        this.detailName_id = detailNameId;
    }
}
