package is.hi.hbv501g.BaraSpara;

import is.hi.hbv501g.BaraSpara.Entities.Transaction;
import is.hi.hbv501g.BaraSpara.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class TransactionController {
    private TransactionService transactionService;
    @Autowired
    public TransactionController(TransactionService transactionService){
        this.transactionService=transactionService;
    }

    @RequestMapping("/")
    public String Transaction(Model model){
        model.addAttribute("transactions", transactionService.findAll());
        return "Velkominn";
    }

    @RequestMapping(value = "/addTransaction", method = RequestMethod.POST)
    //TODO Add @Valid and fix import and error handling
    public String addTransaction(Transaction transaction, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "addTransaction";
        }

        //saves transaction and returns updated list of transactions
        transactionService.save(transaction);
        model.addAttribute("transactions", transactionService.findAll());
        return "Velkominn";
    }

    //TODO error handling og HTML síðu
    @RequestMapping(value = "/addTransaction", method = RequestMethod.GET)
    public String addTransactionForm(Transaction transaction){
        return "addTransaction";
    }

    //TODO HTML síðu /delete
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteTransaction(@PathVariable("id") long id, Model model){
        Transaction sType = transactionService.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("Invalid transaction ID"));

        transactionService.delete(sType);
        model.addAttribute("transactions", transactionService.findAll());
        return "Velkominn";
    }

}
