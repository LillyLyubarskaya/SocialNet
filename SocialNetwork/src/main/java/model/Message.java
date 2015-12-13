package model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Lilly_94 on 25.11.2015.
 */
@Entity
@Table(name="MESSAGE")
public class Message {
    private int id;
    public void setDate(Date date) {
        this.date = date;
    }
    @Column(name="DATE")
    public Date getDate() {

        return date;
    }

    private Date date;
    public void setId(int id) {
        this.id = id;
    }
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="ID")
    public int getId() {

        return id;
    }

    private User from;

    private User to;
    private String text;

    public void setFrom(User from) {
        this.from = from;
    }

    public void setTo(User to) {
        this.to = to;
    }

    public void setText(String text) {
        this.text = text;
    }
    @ManyToOne
    public User getFrom() {

        return from;
    }
    @ManyToOne
    public User getTo() {
        return to;
    }

    public String getText() {
        return text;
    }
}
