package Peaksoft.service;

import Peaksoft.config.HibernateConfig;
import Peaksoft.database.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;


public class UserDaoImpl implements Userdao {

    /**
     * #0-Create table with users Aza
     */
    @Override
    public long addUser(User user) {
        Session session = HibernateConfig.getSession().openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
        System.out.println("User added/created successfully "+ user);

        return user.getId();
    }

    /**
     * #1-SELECT * FROM users where user_name = 'Aza' AND user_age>20;
     * @param user_name
     * @param user_age
     */
    @Override
    public List<User> findByNameAndByAge(String user_name, int user_age) {
        Session session = HibernateConfig.getSession().openSession();
        session.beginTransaction();
        Query query = session.createQuery("FROM User WHERE user_name =?1 and user_age>?2");
        query.setParameter(1,user_name);
        query.setParameter(2,user_age);
        List<User>users = query.list();
        for (User u:users
             ) {
            System.out.println(u);
        }
        session.getTransaction().commit();
        session.close();
        return users;
    }

    /**
     * #2- UPDATE Users SET user_age =18 where user_name ='Aza';

     */
    @Override
    public void setUserAgeById(String user_name, int user_age) {
        Session session = HibernateConfig.getSession().openSession();
        session.beginTransaction();
        Query query = session.createQuery("UPDATE User set user_age =?1 where user_name=?2");
        query.setParameter(1,user_age);
        query.setParameter(2,user_name);
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();

    }

    /**
     * DELETE FROM users WHERE user_name = 'Aza';

     */
    @Override
    public void deleteUserByName(String user_name) {
        Session session = HibernateConfig.getSession().openSession();
        session.beginTransaction();
        Query query = session.createQuery("DELETE User WHERE user_name=?1");
        query.setParameter(1,user_name);
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<User> getAllUsers() {
        Session session = HibernateConfig.getSession().openSession();
        session.beginTransaction();
        List<User> userList = session.createQuery("FROM User").getResultList();
        for (User user:userList
             ) {
            System.out.println(user);
        }
        session.getTransaction().commit();
        session.close();
        return userList;
    }
}

//    private User user;
//
//
//    /**
//     * This method is used to CREATE new table, and we can call as below
//     */
//    @Override
//    public long addUser(User user) {
//        Session session = HibernateConfig.getSession().openSession();
//        session.beginTransaction();
//        session.save(user);
//        session.getTransaction().commit();
//        session.close();
//        System.out.println("New user added successfully:" + user);
//        return user.getId();
//    }
//
//
//    @Override
//    public void updateUserAge(long id, int user_age) {
//        Session session = HibernateConfig.getSession().openSession();
//        session.beginTransaction();
//        User user = session.get(User.class, id);
//        user.setUser_age(user_age);
//        session.getTransaction().commit();
//        session.close();
//        System.out.println("User age updated successfully: " + user);
//    }
//
//    @Override
//    public void deleteUserById(long id) {
//        /** DELETE FROM User WHERE id=?*/
//        Session session = HibernateConfig.getSession().openSession();
//        session.beginTransaction();
//        User user = session.get(User.class, id);
//        session.delete(user);
//        session.getTransaction().commit();
//        session.close();
//        System.out.println("User deleted successfully " + user);
//    }
//
//    @Override
//    public User getUserById(long id) {
//        Session session = HibernateConfig.getSession().openSession();
//        session.beginTransaction();
//        User user = session.get(User.class, id);
//        session.getTransaction().commit();
//        session.close();
//        return user;
//    }
//
//    @Override
//    public void deleteUserAllData() {
//        /**DROP TABLE users */
//        Session session = HibernateConfig.getSession().openSession();
//        session.beginTransaction();
//        Query query = session.createQuery("DELETE FROM User");
//        query.executeUpdate();
//        session.getTransaction().commit();
//        session.close();
//    }
