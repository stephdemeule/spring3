package projet.spring3.annotation;

import org.springframework.stereotype.Service;
import sp3.Oracle;

@Service("oracle")
public class BookwormOracle implements Oracle {

    public String defineMeaningOfLife() {
        return "Encyclopedias are a waste of money - use the Internet";
    }
}
