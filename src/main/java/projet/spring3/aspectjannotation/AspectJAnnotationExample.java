package projet.spring3.aspectjannotation;

import org.springframework.context.support.GenericXmlApplicationContext;

public class AspectJAnnotationExample {

    public static void main(String[] args) {

        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:aspectjannotation.xml");
        ctx.refresh();

        MyBean myBean = (MyBean) ctx.getBean("myBean");
        myBean.execute();

    }
}
