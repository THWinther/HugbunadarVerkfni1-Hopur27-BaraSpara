package is.hi.hbv501g.BaraSpara.Services;

import is.hi.hbv501g.BaraSpara.Entities.Transaction;

import java.util.List;

public interface TransactionService {
    Transaction save(Transaction transaction); // Vistar Saving týðuna
    void delete(Transaction transaction);     // Eyðir Saving úr gagnagrunni
    List<Transaction> findAll();           // Skilar öllum savings úr grunninum
    List<Transaction> findBySavingTypeId(long savingTypeId);
    List<Transaction> findById(long id);
}
