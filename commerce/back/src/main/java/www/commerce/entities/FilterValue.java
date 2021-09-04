package www.commerce.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@AllArgsConstructor
@ToString
@Table(name="FilterValues")
public class FilterValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 255, nullable = false)
    private String name;

    private boolean isDeleted;

    private boolean isAdmin;

    @CreatedDate
    private LocalDateTime createdAt;

    private int filterName_id;

    public FilterValue() {

    }

    public FilterValue(String name, boolean isDeleted, boolean isAdmin, int filterNameId) {
        this.name = name;
        this.isDeleted = isDeleted;
        this.isAdmin = isAdmin;
        this.filterName_id = filterNameId;
    }
}
