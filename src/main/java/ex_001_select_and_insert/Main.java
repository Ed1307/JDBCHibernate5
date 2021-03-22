package ex_001_select_and_insert;



import ex_001_select_and_insert.entity.Author;

import java.util.List;

/**
 * Created by Asus on 01.11.2017.
 */
public class Main {


    public static void main(String[] args) {
        AuthorHelper ah = new AuthorHelper();

        List<Author> authors = ah.getAuthorList();

        for (Author author : authors) {
            System.out.println(author.getId() + " " + author.getName());
        }

        HibernateUtil.getSessionFactory().close();


    }

}
