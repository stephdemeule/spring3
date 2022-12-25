package projet.spring3.proxies;

public class SimpleBean implements ISimpleBean {

    private long dummy = 0;
    public void advised() {
        dummy = System.currentTimeMillis();
    }

    public void unadvised() {
        dummy = System.currentTimeMillis();
    }
}
