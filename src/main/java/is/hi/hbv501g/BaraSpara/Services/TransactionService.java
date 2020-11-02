package is.hi.hbv501g.BaraSpara.Services;

import is.hi.hbv501g.BaraSpara.Entities.Transaction;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface TransactionService {
    Transaction save(Transaction transaction);
    void delete(Transaction transaction);
    List<Transaction> findAll();
    List<Transaction> findByName(String name);
    Optional<Transaction> findById(long id);
    List<Transaction> findBySavingTypeID(long savingTypeID);
    List<Transaction> findByDate(Date date);
}