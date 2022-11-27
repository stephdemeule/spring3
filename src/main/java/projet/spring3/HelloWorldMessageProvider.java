package projet.spring3;

public class HelloWorldMessageProvider implements MessageProvider {

    public String getMessage() {
        return "Salut le monde !!!";
    }
}