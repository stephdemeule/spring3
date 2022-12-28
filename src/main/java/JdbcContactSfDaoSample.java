import org.springframework.context.support.GenericXmlApplicationContext;
import projet.spring3.dao.ContactSfDao;

public class JdbcContactSfDaoSample {

    public static void main(String[] args) {

        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:app-context-sf.xml");
        ctx.refresh();

        ContactSfDao contactSfDao = ctx.getBean("contactSfDao", ContactSfDao.class);

        System.out.println(contactSfDao.getFirstNameById(1l));
    }
}

