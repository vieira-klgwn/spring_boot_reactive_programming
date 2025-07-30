package rw.rca.ereactive.model;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Setter
@Getter
@Table("book")
public class Book {

    @Id
    private Long id;

    private String name;

    private Integer pubYear;
    private Double cost;

    public Book() {
        super();
    }

    public Book(Long id, String name, Integer pubYear, Double cost) {
        super();
        this.id = id;
        this.name = name;
        this.pubYear = pubYear;
        this.cost = cost;
    }

    public Book(String name, Integer pubYear, Double cost) {
        super();
        this.name = name;
        this.pubYear = pubYear;
        this.cost = cost;
    }
}