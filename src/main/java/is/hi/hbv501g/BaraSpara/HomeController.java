package is.hi.hbv501g.BaraSpara;

import is.hi.hbv501g.BaraSpara.Entities.SavingType;
import is.hi.hbv501g.BaraSpara.Entities.Transaction;
import is.hi.hbv501g.BaraSpara.Services.SavingTypeService;
import is.hi.hbv501g.BaraSpara.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;


@Controller
public class HomeController {

    private SavingTypeService savingTypeService;
    private TransactionService transactionService;

    @Autowired
    public HomeController(SavingTypeService savingTypeService, TransactionService transactionService){
        this.savingTypeService=savingTypeService;
        this.transactionService = transactionService;
    }



    @RequestMapping("/")
    public String Home(Model model){
        model.addAttribute("savingTypes", savingTypeService.findAll());
        return "Velkominn";
    }

    @RequestMapping(value = "/addSavingType", method = RequestMethod.POST)
    //TODO Add @Valid and fix import and error handling
    public String addSavingType(SavingType savingType, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "addSavingType";
        }

        //Vistar nýju SavingType og skilar nýja listanum með model
        savingTypeService.save(savingType);
        model.addAttribute("savingTypes", savingTypeService.findAll());
        return "Velkominn";
    }

    //TODO error handling og HTML síðu
    @RequestMapping(value = "/addSavingType", method = RequestMethod.GET)
    public String addSavingTypeForm(SavingType savingType){
        return "addSavingType";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteSavingType(@PathVariable("id") long id, Model model){
        SavingType sType = savingTypeService.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("Invalid SavingTypeID"));

        savingTypeService.delete(sType);
        model.addAttribute("savingTypes", savingTypeService.findAll());
        return "Velkominn";
    }

    @RequestMapping(value="/lookAtExpense/{id}", method = RequestMethod.GET)
    public String lookAtSavingType(@PathVariable("id") long id, Model model){
        Optional<SavingType> sType = savingTypeService.findById(id);
        if(sType.isEmpty()) return "Velkominn";
        List<Transaction> transactions = transactionService.findBySavingTypeId(sType.get().getId());
        model.addAttribute("currentSavingType", sType.get());
        model.addAttribute("transactions", transactions);
        return "lookAtExpense";
    }
}
