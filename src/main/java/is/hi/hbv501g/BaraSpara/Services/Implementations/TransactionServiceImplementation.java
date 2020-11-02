package is.hi.hbv501g.BaraSpara.Services.Implementations;


import is.hi.hbv501g.BaraSpara.Entities.Transaction;
import is.hi.hbv501g.BaraSpara.Repositories.TransactionRepo;
import is.hi.hbv501g.BaraSpara.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.Date;

@Service
public class TransactionServiceImplementation implements TransactionService {
    TransactionRepo repo;

    @Autowired
    public TransactionServiceImplementation(TransactionRepo transactionRepo){
        this.repo = transactionRepo;
    }

    @Override
    public Transaction save(Transaction transaction) {
        return repo.save(transaction);
    }

    @Override
    public void delete(Transaction transaction) {
        repo.delete(transaction);
        return;
    }

    @Override
    public List<Transaction> findAll() {
        return repo.findAll();
    }

    @Override
    public List<Transaction> findByName(String name) {
        return repo.findByName(name);
    }

    @Override
    public Optional<Transaction> findById(long id) {
        return repo.findById(id);
    }

    @Override
    public List<Transaction> findBySavingTypeID(long savingTypeID) {
        return repo.findBySavingTypeID(savingTypeID);
    }

    @Override
    public List<Transaction> findByDate(Date date) {
        return repo.findByDate(date);
    }
}
