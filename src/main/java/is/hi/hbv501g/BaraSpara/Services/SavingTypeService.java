package is.hi.hbv501g.BaraSpara.Services;

import is.hi.hbv501g.BaraSpara.Entities.SavingType;

import java.util.List;
import java.util.Optional;

public interface SavingTypeService {
    SavingType save(SavingType savingType); // Vistar Saving týðuna
    void delete(SavingType savingType);     // Eyðir Saving úr gagnagrunni
    List<SavingType> findAll();             // Skilar öllum savings úr grunninum
    List<SavingType> findByTitle(String title);
    Optional<SavingType> findById(long id);
}
