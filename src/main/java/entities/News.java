package entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "news")
@Builder
@Getter
@Setter
@ToString
public class News {

    @Id
    private Integer id;

    @Column(name = "news_header")
    private String newsHeader;

    @Column(name = "news_text")
    private String newsText;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "public_time")
    private LocalDateTime publicTime;


}
