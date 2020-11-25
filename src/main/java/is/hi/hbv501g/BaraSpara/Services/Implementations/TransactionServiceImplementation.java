package is.hi.hbv501g.BaraSpara.Services.Implementations;

import is.hi.hbv501g.BaraSpara.Entities.Transaction;
import is.hi.hbv501g.BaraSpara.Repositories.TransactionRepo;
import is.hi.hbv501g.BaraSpara.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
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

        List<Transaction> initialList =repo.findAll();
        List<Transaction> returnList = new ArrayList<Transaction>();

        for(int i=0;i<initialList.size();i++){
            if(initialList.get(i).getSavingTypeId()==savingTypeId) returnList.add(initialList.get(i));
        }
        return returnList;
    }


    @Override
    public List<Transaction> findById(long id) {
        return repo.findById(id);
    }
}
