package ex_003_generated_id;

import ex_001_select_and_insert.*;
import ex_003_generated_id.entity.Author;

/**
 * Created by Asus on 04.11.2017.
 */
public class Main {

 //   private static final Logger LOG = Logger.getLogger(AuthorHelper.class.getName());

    public static void main(String[] args) {
         AuthorHelper ah = new AuthorHelper();

         Author author = new Author("Kirill");
         author.setLastName("Abramov");

         ah.addAuthor(author);
         HibernateUtil.getSessionFactory().close();
    }

}
