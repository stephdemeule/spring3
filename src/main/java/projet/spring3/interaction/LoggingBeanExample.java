package projet.spring3.interaction;

import org.springframework.context.support.GenericXmlApplicationContext;

public class LoggingBeanExample {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:logging.xml");
        ctx.refresh();

        LoggingBean bean = (LoggingBean) ctx.getBean("loggingBean");
        bean.someOperation();
    }
}
