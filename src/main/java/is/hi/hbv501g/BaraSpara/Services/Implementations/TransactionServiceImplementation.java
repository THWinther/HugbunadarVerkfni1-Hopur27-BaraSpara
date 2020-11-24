package is.hi.hbv501g.BaraSpara.Services.Implementations;

import is.hi.hbv501g.BaraSpara.Entities.Transaction;
import is.hi.hbv501g.BaraSpara.Repositories.TransactionRepo;
import is.hi.hbv501g.BaraSpara.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImplementation implements TransactionService {
    TransactionRepo repo;

    @Autowired
    public TransactionServiceImplementation(TransactionRepo tansactionRepositorie){
        this.repo = tansactionRepositorie;
    }

    @Override
    public Transaction save(Transaction transaction) {
        repo.save(transaction);
        return transaction;
    }

    @Override
    public void delete(Transaction transaction) {
        repo.delete(transaction);
    }

    @Override
    public List<Transaction> findAll() {
        return repo.findAll();
    }

    @Override
    public List<Transaction> findBySavingTypeId(long savingTypeId) {
        List<Transaction> op =repo.findAll();

        op = op.stream().filter(
                t-> t.getSavingTypeId()==savingTypeId).collect(Collectors.toList()
        );

        return op;
    }


    @Override
    public List<Transaction> findById(long id) {
        return repo.findById(id);
    }
}
