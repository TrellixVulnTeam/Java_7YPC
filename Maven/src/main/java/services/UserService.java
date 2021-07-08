package services;

import Models.Role;
import Models.User;
import org.hibernate.Session;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class UserService {

    public void AddUser(User user){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }

    public void EditUser(User user){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
        session.close();
    }

    public void DeleteUser(User user){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(user);
        session.getTransaction().commit();
        session.close();
    }

    public User GetUserById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        User user = session.get(User.class, id);
        session.close();
       return user;
    }

    public List<User> GetAll() {
        //List<User> users = (List<User>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From User").list();
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();

        List<User> users = (List<User>)session.createQuery("From User").list();
        session.close();
        //HibernateSessionFactoryUtil.getSessionFactory().close();
        return users;
    }
}
