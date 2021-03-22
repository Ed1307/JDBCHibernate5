package ex_002_insert_and_update;

import ex_001_select_and_insert.*;
import ex_002_insert_and_update.entity.Author;
import ex_002_insert_and_update.entity.Book;

import java.util.List;

/**
 * Created by Asus on 04.11.2017.
 */
public class Main {

 //   private static final Logger LOG = Logger.getLogger(AuthorHelper.class.getName());

    public static void main(String[] args) {
        //AuthorHelper ah = new AuthorHelper();
        BookHelper bh = new BookHelper();

//        Book book = new Book();
//        book.setName("Lev");
//        book.setAuthorId(1);
//
//        bh.addBook(book);

        //ah.updateAuthor(2, "Gregory", "Skovoroda");
        //ah.fillAuthor();
        //ah.updateAuthor(1);
        //bh.updateBook(1);


        bh.getSession().close();
        HibernateUtil.getSessionFactory().close();

      //  ah.addAuthor(null);

    }

}
