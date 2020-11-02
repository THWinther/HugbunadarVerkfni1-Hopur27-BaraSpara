package is.hi.hbv501g.BaraSpara.Repositories;


import is.hi.hbv501g.BaraSpara.Entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.Date;

public interface TransactionRepo extends JpaRepository<Transaction, Long> {
    Transaction save(Transaction transaction);
    void delete(Transaction transaction);
    List<Transaction> findAll();
    List<Transaction> findByName(String name);
    Optional<Transaction> findById(long id);
    List<Transaction> findBySavingTypeID(long savingTypeID);
    List<Transaction> findByDate(Date date);
}
