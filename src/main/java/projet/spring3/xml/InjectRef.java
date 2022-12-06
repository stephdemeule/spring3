package projet.spring3.xml;

import org.springframework.context.support.GenericXmlApplicationContext;
import sp3.Oracle;

public class InjectRef {

    private Oracle oracle;

    public void setOracle(Oracle oracle) {
        this.oracle = oracle;
    }

    public static void main(String[] args) {

        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:app-context.xml");
        ctx.refresh();

        InjectRef injectRef = (InjectRef) ctx.getBean("injectRef");
        System.out.println(injectRef);
    }

    public String toString() {
        return oracle.defineMeaningOfLife();
    }
}
