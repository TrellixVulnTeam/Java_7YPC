package www.commerce.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="tblFilterNames")
public class FilterNames {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 255, nullable = false)
    private String name;

    private boolean IsDeleted;

    private boolean IsAdmin;

    @CreatedDate
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name="category_id", nullable = false)
    private Category categoryId;

    @OneToMany
    @JoinColumn(name="filterNames_id")
    private List<FilterValues> values;

    public FilterNames() {
        this.values = new ArrayList<>();
    }
}
