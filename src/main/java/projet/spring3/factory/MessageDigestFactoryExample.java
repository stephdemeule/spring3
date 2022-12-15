package projet.spring3.factory;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MessageDigestFactoryExample {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:factoryMethod.xml");
        ctx.refresh();

        MessageDigester digester = (MessageDigester) ctx.getBean("digester");
        digester.digest("Hello World!");

    }
}