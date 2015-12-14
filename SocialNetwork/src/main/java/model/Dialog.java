package model;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
/**
 * Created by Lilly_94 on 25.11.2015.
 */
@Entity
@Table(name="DIALOGS")
public class Dialog {
    private int id;
    private Set<Message> messages =new HashSet<Message>();

    public void setId(int id) {
        this.id = id;
    }

    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="id")
    public int getId() {
        return id;
    }
    @OneToMany(fetch = FetchType.EAGER)
    public Set<Message> getMessages() {
        return messages;
    }


}
