package is.hi.hbv501g.BaraSpara.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SavingType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    private int maxSpending;

    public SavingType(){
    }

    public SavingType(String title, int maxSpending){
        this.title = title;
        this.maxSpending = maxSpending;
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
}
