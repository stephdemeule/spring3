package projet.spring3.lifecycle;

import org.springframework.context.support.GenericXmlApplicationContext;

public class ShutdownHookExample {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:disposeInterface.xml");
        ctx.registerShutdownHook();
        ctx.refresh();

        DestructiveBeanWithInterface bean = (DestructiveBeanWithInterface)
                ctx.getBean("destructiveBean");
    }
}
