package dao;

import antlr.collections.List;
import entities.Category;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import util.HibernateUtil;

public class CategoryDao {
    public Integer create(Category category) {
        Session session = HibernateUtil.buildSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(category);
        session.getTransaction().commit();
        session.close();
        System.out.println(category.toString());
        return category.getId();
    }

    public Category update(Category category) {
        Session session = HibernateUtil.buildSessionFactory().openSession();
        session.beginTransaction();
        Category category1 = (Category) session.load(Category.class, category.getId());
        category1.setName(category1.getName());
        session.getTransaction().commit();
        session.close();
        return category;
    }

    public List CategoryView(){
        Session session = HibernateUtil.buildSessionFactory().openSession();
        String sql = "SELECT * FROM category";
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(Category.class);
        List categories = (List) query.list();
        session.close();
        System.out.println(categories);
        return categories;
    }

}
