package projet.spring3.interaction;

import org.springframework.context.support.GenericXmlApplicationContext;
import projet.spring3.lifecycle.DestructiveBeanWithInterface;

public class ShutdownHookBeanExample {
    public static void main(String[] args) {

        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("shutdownHook.xml");
        ctx.refresh();

        DestructiveBeanWithInterface bean =
                (DestructiveBeanWithInterface) ctx.getBean("destructiveBean");
    }
}
