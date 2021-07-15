package app;

import Models.*;
import com.github.javafaker.Faker;
import org.hibernate.Session;
import org.hibernate.dialect.identity.HANAIdentityColumnSupport;
import org.hibernate.query.Query;
import services.UserService;
import utils.HibernateSessionFactoryUtil;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.awt.geom.QuadCurve2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String [] args){
        try{
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            System.out.println("Working data base...");

            //CreateAuthor(session);
            //FillAuthorAndBooks(session);
            //CreateUserAndRole(session);
            //TestUserService();
            //FillQuestions(session);
            Searching(session);

            session.close();
        }
        catch (Exception ex){
            System.out.println("error -> " + ex.getMessage());
        }
    }


    public static void CreateAuthor(Session session){

        Scanner in = new Scanner(System.in);
        String surname = "";
        String name = "";
        while (true)
        {
            surname = "";
            name = "";

            System.out.println("Enter author name:");
            System.out.printf("->_");
            name = in.nextLine();

            if(!name.isEmpty()){
                System.out.println("Enter author surname:");
                System.out.printf("->_");
                surname = in.nextLine();

                if(!surname.isEmpty()){
                    System.out.println("<<< Author is add >>>");
                    session.beginTransaction();
                    Author author = new Author(name, surname);
                    session.save(author);
                    session.getTransaction().commit();
                }
                else break;
            }
            else{
                System.out.println("<<< Author is not add >>>");
                System.out.println("<<< Authors from database >>>");
                List<Author> authors = session.createQuery("from Author").list();
                for(Author a : authors){
                    System.out.println(a.getFirstName() + "  " + a.getLastName()
                    );
                }
            }
        }
    }

    public static void FillAuthorAndBooks(Session session){
//        session.beginTransaction();
//
//        Faker faker = new Faker();
//
//        for (int i = 0 ; i<10; i++){
//            String firstName = faker.name().firstName();
//            String lastName = faker.name().lastName();
//
//            Author author = new Author(firstName, lastName);
////            System.out.println(String.format("%s\t%s\n",
////                    firstName,
////                    lastName
////            ));
//            session.save(author);
//        }
//        session.getTransaction().commit();


//        session.beginTransaction();
//        Random random = new Random(System.nanoTime());
//        Faker faker = new Faker();
//
//        for (int i = 0 ; i<100; i++){
//            String name = faker.book().title();
//            String description = faker.book().genre();
//            int year = 1960 + random.nextInt(50);
//            int author_id = 21 + random.nextInt(10);
//
//            Book book = new Book(name, year, description, author_id);
//            System.out.println(String.format("%s %s %s %s",
//                    name,
//                    year,
//                    description,
//                    author_id
//
////            ));
//            session.save(book);
//        }
//        session.getTransaction().commit();


    }

    public static void CreateUserAndRole(Session session){
        session.beginTransaction();

        Role role = new Role("Admin");
        session.save(role);

        User user = new User("Patric");
        user.getRoles().add(role);

        session.save(user);
        session.getTransaction().commit();
        session.close();
    }

    public static void TestUserService(){

        Scanner in = new Scanner(System.in);

        UserService us = new UserService();

        User user = new User("Lois");
        us.AddUser(user);

        boolean bool = true;
        while (bool){
            System.out.println(" 1. Show all\n 2. Show by id\n 3. Delete\n 4. Add new\n 5. Edit\n 0. Exit");
            int choice = in.nextInt();

            switch (choice){
                case 1:
                    List<User> users = us.GetAll();
                    for(User u : users){
                        System.out.println(u.getId() + ": " + u.getName());
                    }
                    break;
                case 2:
                    User getUser = us.GetUserById(user.getId());
                    System.out.println("Get USER -> " + getUser.getName());
                    break;
                case 3:
                    getUser = us.GetUserById(user.getId());
                    us.DeleteUser(getUser);
                    break;
                case 4:
                    User u = new User("Lois");
                    us.AddUser(u);
                    break;
                case 5:
                    user.setName("Marcus");
                    us.EditUser(user);
                    break;
                case 0:
                    bool = false;
                    break;
            }
        }
    }

    public static void FillQuestions(Session session){
        session.beginTransaction();

       List<Question> array = new ArrayList<Question>();
            array.add(new Question("Is cereal with milk a soup? Why or why not?", true)) ;
            array.add(new Question("What is the sexiest and most non-sexual name?", true)) ;
            array.add(new Question("What secret conspiracy would you like to start?", false)) ;
            array.add(new Question("What is impossible to see, but would you like people to be able to see?", true)) ;
            array.add(new Question("What's the weirdest smell you've ever smelled (la)?", true)) ;
            array.add(new Question("Is a hot dog a sandwich? Why or why not?", false)) ;
            array.add(new Question("What's the best Wi-Fi name you've ever seen?", true)) ;
            array.add(new Question("Funniest fact you know?", true)) ;
            array.add(new Question("What is every person doing stupidly?", true)) ;
            array.add(new Question("What's the funniest joke you know by heart?", false)) ;
            array.add(new Question("Why will people feel nostalgic in 40 years?", true)) ;
            array.add(new Question("What are the unwritten rules for where you work?", true)) ;
            array.add(new Question("How do you feel about pineapple on pizza?", false)) ;


        for(Question q: array){
            session.save(q);
        }

        session.getTransaction().commit();
    }

    public static void Searching(Session session){

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Book> cr = cb.createQuery(Book.class);
        Root<Book> root = cr.from(Book.class);
        //cr.select(root);

        Scanner in = new Scanner(System.in);

        System.out.println(" 1: By name\n 2: By author:\n 3: By desc\n 4: By year\n 5: EXIT");
        System.out.printf("->_");
        int search_by = in.nextInt();
        String search_fraze = "";

        switch (search_by){
            case 1:
                search_fraze = Search_by_name();
                cr.select(root).where(cb.like(root.<String>get("name"), "%" + search_fraze + "%"));
                break;
            case 2:
                int search_author = Search_author(session);
                System.out.println("Author ID >> "+ search_author);
                cr.select(root).where(cb.equal(root.<String>get("author"), search_author));
                break;
            case 3:
                search_fraze = Search_by_desc();
                cr.select(root).where(cb.like(root.<String>get("description"), "%" + search_fraze + "%"));
                break;
            case 4:
                int search_year = Search_by_year();
                cr.select(root).where(cb.equal(root.<String>get("year"), search_year));
                break;
            case 5:
                break;
            default:
                break;
        }

        Query<Book> query = session.createQuery(cr);
        List<Book> results = query.getResultList();

        for (Book i : results){
            System.out.println(i.getId() +" --- " + i.getName() + " --- " + i.getAuthor().getFirstName());
        }
    }

    static int Search_author(Session session){
        Scanner in = new Scanner(System.in);
        CriteriaBuilder c = session.getCriteriaBuilder();
        CriteriaQuery<Author> ck = c.createQuery(Author.class);
        Root<Author> rootA = ck.from(Author.class);

        System.out.println("Enter searching author : ");
        System.out.printf("->_");
        String search_fraze = in.nextLine();

        ck.select(rootA).where(c.like(rootA.<String>get("firstName"), "%" + search_fraze + "%"));

        Query<Author> queryA = session.createQuery(ck);
        List<Author> resultsA = queryA.getResultList();

        int search_author = 0;
        search_author = resultsA.get(0).getId();
        return search_author;
    }

    static String Search_by_name(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter searching name : ");
        System.out.printf("->_");
        String  search_fraze = in.nextLine();
        return  search_fraze;
    }

    static String Search_by_desc(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter searching desc : ");
        System.out.printf("->_");
        String search_fraze = in.nextLine();
        return search_fraze
    }

    static int Search_by_year(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter searching year : ");
        System.out.printf("->_");
        int search_year = in.nextInt();
        return search_year;
    }
}
