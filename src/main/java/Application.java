import entities.Category;
import entities.News;
import lombok.Builder;
import org.hibernate.Session;
import util.HibernateUtil;

import java.time.LocalDateTime;


@Builder
public class Application {
    private static java.util.Objects Objects;
    private static final Session hibernateSession = Objects.requireNonNull(HibernateUtil.
            buildSessionFactory()).
            openSession();

        public static void main(String[] args){
    hibernateSession.beginTransaction();

    Category category = Category.builder()
            .id(1)
            .name("sport")
            .build();

    Category category1 = Category.builder()
            .id(2)
            .name("local_news")
            .build();

    Category category2 = Category.builder()
            .id(3)
            .name("forein_news")
            .build();

    News news = News.builder()
            .newsHeader("Header1")
            .newsText("Text1")
            .category(category)
            .publicTime(LocalDateTime.now())
            .build();

    News news1 = News.builder()
            .newsHeader("Header2")
            .newsText("Text2")
            .category(category1)
            .publicTime(LocalDateTime.now())
            .build();

    News news2 = News.builder()
            .newsHeader("Header3")
            .newsText("Text3")
            .category(category1)
            .publicTime(LocalDateTime.now())
            .build();

    hibernateSession.save(category);
    hibernateSession.save(category1);
    hibernateSession.save(category2);
    hibernateSession.save(news);
    hibernateSession.save(news1);
    hibernateSession.save(news2);

    hibernateSession.getTransaction().commit();
    hibernateSession.close();

    }

}
