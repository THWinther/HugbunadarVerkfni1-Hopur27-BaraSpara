package is.hi.hbv501g.BaraSpara.Repositories;

import is.hi.hbv501g.BaraSpara.Entities.SavingType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface SavingTypeRepo extends JpaRepository<SavingType, Long> {

    SavingType save(SavingType savingType); // Vistar Saving týpuna
    void delete(SavingType savingType);     // Eyðir Saving úr gagnagrunni
    List<SavingType> findAll();             // Skilar öllum savings úr grunninum
    List<SavingType> findByTitle(String title);
    Optional<SavingType> findById(long id);
}
