import org.hibernate.Session;
import org.hibernate.dialect.identity.HANAIdentityColumnSupport;
import utils.HibernateSessionFactoryUtil;

public class Main {
    public static void main(String [] args){
        try{
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            System.out.println("Working data base...");
            session.close();
        }
        catch (Exception ex){
            System.out.println("error -> " + ex.getMessage());
        }
    }
}
