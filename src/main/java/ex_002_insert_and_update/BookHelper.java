package ex_002_insert_and_update;

import ex_002_insert_and_update.entity.Author;
import ex_002_insert_and_update.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class BookHelper {

    private SessionFactory sessionFactory;
    private Session session;

    public BookHelper() {
        sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
    }

    public Book addBook(Book book) {

        session.beginTransaction();
        session.save(book);
        // сгенерит ID и вставит в объект
        session.getTransaction().commit();
        return book;

    }

    public void updateBook(long id) {

        session.beginTransaction();
        Book book = session.get(Book.class, id);

        book.setName("Ed");

        session.save(book);
        // сгенерит ID и вставит в объект
        session.getTransaction().commit();
    }

    public Session getSession() {
        return session;
    }
}
