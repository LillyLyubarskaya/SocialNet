package model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Lilly_94 on 18.11.2015.
 */
@Entity
@Table(name="USER_INFO")
public class UserInfo {
    private int info_id;
    private String name;
    private String surname;
    private Date birthday;
    private String position;
    private String image;

    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Column(name="birthday")
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Column(name="position")
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Column(name="photo")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="info_id")
    public int getInfo_id() {

        return info_id;
    }

    public void setInfo_id(int info_id) {
        this.info_id = info_id;
    }

}

