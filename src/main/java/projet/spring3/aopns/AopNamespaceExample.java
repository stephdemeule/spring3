package projet.spring3.aopns;

import org.springframework.context.support.GenericXmlApplicationContext;

public class AopNamespaceExample {

    public static void main(String[] args) {

        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:aopns.xml");
        ctx.refresh();

        MyBean myBean = (MyBean) ctx.getBean("myBean");
        myBean.execute();
    }
}