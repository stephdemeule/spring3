package projet.spring3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldSpringDI {

    public static void main(String[] args) {

        // Initialize Spring ApplicationContext
        ApplicationContext context = new ClassPathXmlApplicationContext
                ("app-context.xml");

        MessageRenderer mr = context.getBean("renderer", MessageRenderer.class);
        mr.render();
    }
}
