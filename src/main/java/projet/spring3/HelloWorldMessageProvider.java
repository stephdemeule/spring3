package projet.spring3;

import org.springframework.stereotype.Service;

@Service("provider")
public class HelloWorldMessageProvider implements MessageProvider {

    public String getMessage() {
        return "Salut le monde !!!";
    }
}