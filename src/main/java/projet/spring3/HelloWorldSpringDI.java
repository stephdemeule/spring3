package projet.spring3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloWorldSpringDI {

    public static void main(String[] args) {

        // Initialize Spring ApplicationContext
  /*      ApplicationContext context = new ClassPathXmlApplicationContext
                ("app-context-annotation.xml");

        MessageRenderer mr = context.getBean("renderer", MessageRenderer.class);
        mr.render();*/

        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:app-context-annotation.xml");
        ctx.refresh();

        MessageRenderer messageRenderer = ctx.getBean("renderer", MessageRenderer.class);
        messageRenderer.render();
    }
}
