package model;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
/**
 * Created by Lilly_94 on 18.11.2015.
 */
@Entity
@Table(name="USER")
public class User {
    private int id;
    private String email;
    private String password;
    private int status;

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public UserInfo getUserInfo() {

        return userInfo;
    }

    private UserInfo userInfo;

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="user_id")
    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    @Column(name="email")
    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name="password")
    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name="status")
    public int getStatus() {
        return status;
    }


    public void setStatus(int status) {
        this.status = status;
    }

}