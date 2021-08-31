package www.commerce.entities;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@AllArgsConstructor
//@NoArgsConstructor
@ToString
@Table(name="tblDetailValues")
public class DetailValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 255, nullable = false)
    private String name;

    private boolean IsDeleted;

    @ManyToOne
    @JoinColumn(name="detailNames_id", nullable = false)
    private DetailName detailName;

    public DetailValue() {
    }

    public DetailValue(String name, boolean isDeleted, int detailNameId) {
        this.name = name;
        IsDeleted = isDeleted;

        this.detailName = new DetailName();
        this.detailName.setId(detailNameId);
    }
}
