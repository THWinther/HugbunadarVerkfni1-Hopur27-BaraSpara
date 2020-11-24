package is.hi.hbv501g.BaraSpara.Repositories;

import is.hi.hbv501g.BaraSpara.Entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface TransactionRepo extends JpaRepository<Transaction, Long> {

    Transaction save(Transaction transaction); // Vistar Saving týðuna
    void delete(Transaction transaction);     // Eyðir Saving úr gagnagrunni
    List<Transaction> findAll();           // Skilar öllum savings úr grunninum
    List<Transaction> findById(long id);
}
