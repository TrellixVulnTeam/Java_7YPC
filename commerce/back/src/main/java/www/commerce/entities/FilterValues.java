package www.commerce.entities;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="tblFilterValues")
public class FilterValues {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 255, nullable = false)
    private String name;

    private boolean IsDeleted;

    private boolean IsAdmin;

    @CreatedDate
    private LocalDateTime createdAt;

    private int FilterNameId;


}
