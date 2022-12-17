package projet.spring3.context;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Locale;

public class MessageSourceDemo {
    public static void main(String[] args) {

        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:messageSource.xml");
        ctx.refresh();

        Locale english = Locale.ENGLISH;
        Locale czech = new Locale("cs", "CZ");

        System.out.println(ctx.getMessage("msg", null, english));
        System.out.println(ctx.getMessage("msg", null, czech));

        System.out.println(ctx.getMessage("nameMsg", new Object[] { "Clarence",
                "Ho" }, english));
    }
}
