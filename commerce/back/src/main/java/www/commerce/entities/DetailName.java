package www.commerce.entities;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
//@NoArgsConstructor
@ToString
@Table(name="DetailNames")
public class DetailName {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 255, nullable = false)
    private String name;

    private boolean IsDeleted;

    @CreatedDate
    private LocalDateTime createdAt;

    @OneToMany
    @JoinColumn(name="detailName_id")
    private List<DetailValue> values;

    public DetailName() {
        this.values = new ArrayList<>();
    }

    public DetailName(String name, boolean isDeleted) {
        this.name = name;
        IsDeleted = isDeleted;
        this.values = new ArrayList<>();
    }


    public void setId(int id) {
        this.id = id;
    }
}
