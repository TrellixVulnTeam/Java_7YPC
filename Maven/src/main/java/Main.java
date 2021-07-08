import Models.Author;
import Models.Book;
import Models.Role;
import Models.User;
import com.github.javafaker.Faker;
import org.hibernate.Session;
import org.hibernate.dialect.identity.HANAIdentityColumnSupport;
import services.UserService;
import utils.HibernateSessionFactoryUtil;

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
            TestUserService();

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
        UserService us = new UserService();

        User user = new User("Lois");
        us.AddUser(user);

        User getUser = us.GetUserById(user.getId());
        System.out.println("Get USER -> " + getUser.getName());

        user.setName("Marcus");
        us.EditUser(user);

        getUser = us.GetUserById(user.getId());
        System.out.println("Edit USER -> " + getUser.getName());


        List<User> users = us.GetAll();
        for(User u : users){
            System.out.println(u.getId() + ": " + u.getName());
        }


        us.DeleteUser(getUser);

        users.clear();
        users = us.GetAll();
        for(User u : users){
            System.out.println(u.getId() + ": " + u.getName());
        }



    }


}
