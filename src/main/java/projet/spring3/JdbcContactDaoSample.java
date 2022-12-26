package projet.spring3;

import org.springframework.context.support.GenericXmlApplicationContext;
import projet.spring3.dao.ContactDao;
import projet.spring3.domain.Contact;
import projet.spring3.domain.ContactTelDetail;

import java.util.List;

public class JdbcContactDaoSample {
    public static void main(String[] args) {

        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:app-context.xml");
        ctx.refresh();

        ContactDao contactDao = ctx.getBean("contactDao", ContactDao.class);

        // Find first name by id
        System.out.println("First name for contact id 1 is: " +
                contactDao.findFirstNameById(1l));
        System.out.println("Last name for contact id 2 is: " +
                contactDao.findFirstNameById(2l));
        List<Contact> contacts = contactDao.findAll();
        for (Contact contact: contacts) {
            System.out.println(contact);
            if (contact.getContactTelDetails() != null) {
                for (ContactTelDetail contactTelDetail:
                        contact.getContactTelDetails()) {
                    System.out.println("---" + contactTelDetail);
                }
            }
            System.out.println();
        }
        // Find and list all contacts with details
        List<Contact> contactsWithDetail = contactDao.findAllWithDetail();
        for (Contact contact: contactsWithDetail) {
            System.out.println(contact);
            if (contact.getContactTelDetails() != null) {
                for (ContactTelDetail contactTelDetail: contact.getContactTelDetails()) {
                    System.out.println("---" + contactTelDetail);
                }
            }
            System.out.println();
        }

    }
}
