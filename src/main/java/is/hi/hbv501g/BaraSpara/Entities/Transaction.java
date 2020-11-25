package is.hi.hbv501g.BaraSpara.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long savingTypeId=-1;

    private int amount;
    private Date when;

    public Transaction(){

    }

    public Transaction(long savingTypeId, int amount){
        this.amount = amount;
        this.savingTypeId = savingTypeId;
        this.when = new Date();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSavingTypeId() {
        return savingTypeId;
    }

    public void setSavingTypeId(long savingTypeId) {
        this.savingTypeId = savingTypeId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getWhen() {
        return when;
    }

    public void setWhen(Date when) {
        this.when = when;
    }
}
