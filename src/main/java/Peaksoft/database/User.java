package Peaksoft.database;


import com.sun.istack.Nullable;

import javax.persistence.*;

/** POJO class or Entity class*/

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String user_name;
    private String user_lastname;
    private int user_age;
    private String user_email;

    public User() {
    }

    public User(String user_name, String user_lastname, int user_age, String user_email) {
        this.user_name = user_name;
        this.user_lastname = user_lastname;
        this.user_age = user_age;
        this.user_email = user_email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_lastname() {
        return user_lastname;
    }

    public void setUser_lastname(String user_lastname) {
        this.user_lastname = user_lastname;
    }

    public int getUser_age() {
        return user_age;
    }

    public void setUser_age(int user_age) {
        this.user_age = user_age;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }



    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", user_name='" + user_name + '\'' +
                ", user_lastname='" + user_lastname + '\'' +
                ", user_age=" + user_age +
                ", user_email='" + user_email + '\'' +
                '}';
    }
}
