package entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "category")
@Builder
@Getter
@Setter
@ToString
public class Category {
    @Id
    private Integer id;

    @Column(name = "name")
    private String name;


}
