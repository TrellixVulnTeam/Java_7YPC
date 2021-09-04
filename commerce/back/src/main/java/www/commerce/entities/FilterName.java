package www.commerce.entities;

import lombok.AllArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@Table(name="FilterNames")
public class FilterName {

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
    @JoinColumn(name="filterName_id")
    private List<FilterValue> values;

    public FilterName() {
        this.values = new ArrayList<>();
    }

    public FilterName(String name, boolean isDeleted, boolean isAdmin, int categoryId) {
        this.name = name;
        IsDeleted = isDeleted;
        IsAdmin = isAdmin;

        this.categoryId = new Category();
        this.categoryId.setId(categoryId);

        this.values = new ArrayList<>();
    }
}
