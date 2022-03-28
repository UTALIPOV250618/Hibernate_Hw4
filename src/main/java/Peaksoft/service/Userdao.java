package Peaksoft.service;

import Peaksoft.database.User;

import java.util.List;

public interface Userdao {

    /**
     * #0-Create table with users Aza
     */
    long addUser(User user);

    /**
     * #1-SELECT * FROM users where user_name = 'Aza' AND user_age>20;

     */

    List<User> findByNameAndByAge(String user_name,int user_age);

    /**
     * #2- UPDATE Users SET user_age =18 where user_name ='Aza';
     */
    void setUserAgeById(String user_name, int user_age);

/** DELETE FROM users WHERE user_name = 'Aza';*/
    void deleteUserByName(String user_name);
    List<User> getAllUsers();
}





