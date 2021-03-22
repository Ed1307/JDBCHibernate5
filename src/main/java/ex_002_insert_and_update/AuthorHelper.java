package ex_002_insert_and_update;


import ex_002_insert_and_update.entity.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by Asus on 01.11.2017.
 */
public class AuthorHelper {

    private SessionFactory sessionFactory;
    private Session session;

    public AuthorHelper() {
        sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
    }

    public List<Author> getAuthorList(){
        // открыть сессию - для манипуляции с персист. объектами
        Session session = sessionFactory.openSession();


        // этап подготовки запроса

        // объект-конструктор запросов для Criteria API
        CriteriaBuilder cb = session.getCriteriaBuilder();// не использовать session.createCriteria, т.к. deprecated

        CriteriaQuery cq = cb.createQuery(Author.class);

        Root<Author> root = cq.from(Author.class);// первостепенный, корневой entity (в sql запросе - from)


        cq.select(root);// необязательный оператор, если просто нужно получить все значения


         //этап выполнения запроса
        Query query = session.createQuery(cq);

        List<Author> authorList = query.getResultList();

        session.close();

        return authorList;
    }

    public Author getAuthorById(long id) {
        Session session = sessionFactory.openSession();
        Author author = session.get(Author.class, id); // получение объекта по id
        session.close();
        return author;
    }

    public Author addAuthor(Author author) {

        session.beginTransaction();
        session.save(author);
         // сгенерит ID и вставит в объект
        session.getTransaction().commit();
        return author;

    }

    public void updateAuthor(long id, Object... authorData) {

        session.beginTransaction();
        Author author = session.get(Author.class, id);

        author.setName("Ed");

        session.save(author);
        // сгенерит ID и вставит в объект
        session.getTransaction().commit();
    }

    public void fillAuthor (){
        session.beginTransaction();
        for (int i = 0; i < 200; i++){
            session.save(new Author("name " + i));
            if (i%10 == 0){
                session.flush();
            }
        }
        session.getTransaction().commit();
        session.close();
    }

    public Session getSession() {
        return session;
    }

}
