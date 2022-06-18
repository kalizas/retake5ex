package dao;

import entities.News;
import jdk.jfr.Category;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.List;

public class NewsDao {
      public Integer create(News news) {
        Session session = HibernateUtil.buildSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate((Category) news);
        session.getTransaction().commit();
        session.close();
        System.out.println(news.toString());
        return news.getId();
    }

    public News selectNewsHeader(Integer newsHeader) {
        Session session = HibernateUtil.buildSessionFactory().openSession();
        String sql = "SELECT * FROM news n WHERE n.news_header LIKE '%4'";
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(News.class);
        List<News> news = query.list();
        session.close();
        System.out.println(news);
        return (News) news;
    }

    public List<News> NewsView(){
        Session session = HibernateUtil.buildSessionFactory().openSession();
        String sql = "SELECT * FROM news";
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(News.class);
        List<News> news = query.list();
        session.close();
        System.out.println(news);
        return news;
    }

    public News update(News news) {
        Session session = HibernateUtil.buildSessionFactory().openSession();
        session.beginTransaction();
        News news1 = (News) session.load(News.class, news.getId());
        news1.setNewsText(news.getNewsText());
        news1.setNewsHeader(news.getNewsHeader());
        session.getTransaction().commit();
        session.close();
        return news;
    }

}
