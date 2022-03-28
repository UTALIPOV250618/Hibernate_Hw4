package Peaksoft;

import Peaksoft.config.HibernateConfig;
import Peaksoft.database.User;
import Peaksoft.service.UserDaoImpl;
import org.hibernate.Session;


public class App 
{
    public static void main( String[] args )
    {
//        User user = new User("Dati","Talipova",27,"dati@gmail.com");
        UserDaoImpl userDao = new UserDaoImpl();
//        userDao.addUser(user);
//        userDao.findByNameAndByAge("Aza",20);
//        userDao.setUserAgeById("Aza",22);
//        userDao.deleteUserByName("Aza");
        userDao.getAllUsers();



    }



}
