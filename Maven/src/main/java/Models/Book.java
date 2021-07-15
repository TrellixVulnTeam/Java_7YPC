package Models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="tbl_books")
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name", nullable = false, length = 100)
    private String name;

    //@Column(name="year", nullable = false)
    private int year;

    @Column(name="description", length = 400)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="author_id")
    private Author author;

    public Book() {
    }

    public Book(String name, int year, String desc, int author_id) {
        this.name = name;
        this.year = year;
        this.description = desc;
        this.author = new Author();
        this.author.setId(author_id);
    }

    public Book(String name, int year, String desc) {
        this.name = name;
        this.year = year;
        this.description = desc;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String desc) {
        this.description = desc;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
