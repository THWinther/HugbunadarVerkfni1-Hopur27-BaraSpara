package is.hi.hbv501g.BaraSpara.Entities;

import javax.persistence.*;

/**
 * Þetta er Entity sem sér um að segja til um
 * hvað er verið að reyna að eyða minna í
 */


@Entity
public class SavingType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    private int maxSpending;

    private String description;

    @ManyToOne
    private User user;

    public SavingType(){
    }

    public SavingType(String title, int maxSpending, String description, User user){
        this.title = title;
        this.maxSpending = maxSpending;
        this.description = description;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getMaxSpending() {
        return maxSpending;
    }

    public void setMaxSpending(int maxSpending) {
        this.maxSpending = maxSpending;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
