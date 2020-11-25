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

import java.util.Date;
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


    /**
     * Þetta er fall sér um að bregðast við boði að sjá heimsíðu
     * Síðunar
     *
     * @param model gagnamódel til að tala á milli html og Java
     * @return skilal streng sem  segir að birta velkominn.html
     */
    @RequestMapping("/")
    public String Home(Model model){
        model.addAttribute("savingTypes", savingTypeService.findAll());
        return "Velkominn";
    }

    /**
     * Þetta fall höndlar POST request til að bæta við nýju saving type
     *
     * @param savingType Klasi sem er verioð að vista
     * @param result    Hlutur sem segir til hvort það voru eitthverjar villur
     * @param model     gagnamódel til að tala á milli html og Java
     * @return  ef það eru engar villur þá skilar það Velkominn.html
     */
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

    /**
     * Meðhöndlar GET request þegar það er verið að biðja um sá síðu
     * @param savingType
     * @return Streng sem segir að nota addSavingType.html
     */
    //TODO error handling og HTML síðu
    @RequestMapping(value = "/addSavingType", method = RequestMethod.GET)
    public String addSavingTypeForm(SavingType savingType){
        return "addSavingType";
    }



    /**
     * Sér um að eyða savingType sem hefur verið valið
     * og þeirra transactions
     *
     * @param id id SavingType sem er verið að eyða
     * @param model gagnamódel til að tala á milli html og Java
     * @return skilar aftur Velkominn.html
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteSavingType(@PathVariable("id") long id, Model model){
        SavingType sType = savingTypeService.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("Invalid SavingTypeID"));

        long saveingID = sType.getId();
        savingTypeService.delete(sType);

        List<Transaction> deleterList = transactionService.findBySavingTypeId(saveingID);
        while(!deleterList.isEmpty()){
            transactionService.delete(deleterList.get(0));
            deleterList.remove(0);
        }

        model.addAttribute("savingTypes", savingTypeService.findAll());
        return "Velkominn";
    }

    /**
     *  Sér um að sýna SavingType sem er valið og Transactions þeirra
     *
     * @param id id SavingType sem er verið að skoða
     * @param model gagnamódel til að tala á milli html og Java
     * @return  beðið um ap sýna lookAtExpense.html
     */
    @RequestMapping(value="/lookAtExpense/{id}", method = RequestMethod.GET)
    public String lookAtSavingType(@PathVariable("id") long id, Model model){
        Optional<SavingType> sType = savingTypeService.findById(id);
        if(sType.isEmpty()) return "Velkominn";
        List<Transaction> transactions = transactionService.findBySavingTypeId(id);
        model.addAttribute("totalAmount", totalTransactionAmount(transactions));
        model.addAttribute("currentSavingType", sType.get());
        model.addAttribute("transactions", transactions);
        model.addAttribute("transaction", new Transaction());

        return "lookAtExpense";
    }


    /** Sér um GET request fyrir addTransaction
     *
     * @param id id savinType sem er verið að skoða
     * @param model gagnamódel til að tala á milli html og Java
     * @return lookAtExpense.html
     */
    @RequestMapping(value="/addTransaction/{id}", method = RequestMethod.GET)
    public String lookTransaction(@PathVariable("id") long id, Model model){
         return "lookAtExpense";
    }

    /**
     * Sér um POST request fyrir addTransaction
     * Vistar Nýju Transaction sem notandi stimplar inn
     *
     * @param transaction transaction sem á að vista
     * @param id    id af savingType sem er verið að skoða
     * @param model gagnamódel til að tala á milli html og Java
     * @return lookAtExpense.html
     */
    @RequestMapping(value="/addTransaction/{id}", method = RequestMethod.POST)
    public String addTransaction(Transaction transaction, @PathVariable("id") long id, Model model){
        transactionService.save(new Transaction(id,transaction.getAmount()));
        Optional<SavingType> sType = savingTypeService.findById(id);
        if(sType.isEmpty()) return "Velkominn";
        List<Transaction> transactions = transactionService.findBySavingTypeId(id);
        model.addAttribute("totalAmount", totalTransactionAmount(transactions));
        model.addAttribute("currentSavingType", sType.get());
        model.addAttribute("transactions", transactions);
        return "lookAtExpense";
    }


    public int totalTransactionAmount(List<Transaction> li){
        int amountTotal = 0;

        for(int i=0;i<li.size();i++){
            amountTotal += li.get(i).getAmount();
        }
        return amountTotal;
    }

}
