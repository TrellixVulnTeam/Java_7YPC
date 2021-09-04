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


}
