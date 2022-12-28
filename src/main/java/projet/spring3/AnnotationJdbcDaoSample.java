package projet.spring3;

import org.springframework.context.support.GenericXmlApplicationContext;
import projet.spring3.dao.ContactDao;
import projet.spring3.domain.Contact;
import projet.spring3.domain.ContactTelDetail;

import java.sql.Date;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class AnnotationJdbcDaoSample {

    public static void main(String[] args) {

        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:app-context-annotation.xml");
        ctx.refresh();

        ContactDao contactDao = ctx.getBean("contactDao", ContactDao.class);

        // Find and list all contacts
        List<Contact> contacts = contactDao.findAll();
        listContacts(contacts);

        // Find contacts by first name
        List contactsByFirstName = contactDao.findByFirstName("Clarence");
        listContacts(contactsByFirstName);

        // Update contact
        Contact contact;
        contact = new Contact();
        contact.setId(1l);
        contact.setFirstName("Clarence");
        contact.setLastName("Peter");
        contact.setBirthDate(new Date((new GregorianCalendar(1977, 10,
                1)).getTime().getTime()));
        contactDao.update(contact);
        contacts = contactDao.findAll();
        listContacts(contacts);

        // Insert contact
        System.out.println("************Insert contract************");
        contact = new Contact();
        contact.setFirstName("Rod");
        contact.setLastName("Johnson");
        contact.setBirthDate(new Date((new GregorianCalendar(2001, 10,
                1)).getTime().getTime()));
        contactDao.insert(contact);
        contacts = contactDao.findAll();
        listContacts(contacts);

        // Insert contact with details
        System.out.println("************Insert batch contract************");
        contact = new Contact();
        contact.setFirstName("Michael");
        contact.setLastName("Jackson");
        contact.setBirthDate(new Date((new GregorianCalendar(1964, 10,
                1)).getTime().getTime()));
        List<ContactTelDetail> contactTelDetails = new ArrayList<ContactTelDetail>();
        ContactTelDetail contactTelDetail = new ContactTelDetail();
        contactTelDetail.setTelType("Home");
        contactTelDetail.setTelNumber("11111111");
        contactTelDetails.add(contactTelDetail);
        contactTelDetail = new ContactTelDetail();
        contactTelDetail.setTelType("Mobile");
        contactTelDetail.setTelNumber("22222222");
        contactTelDetails.add(contactTelDetail);
        contact.setContactTelDetails(contactTelDetails);
        contactDao.insertWithDetail(contact);
        contacts = contactDao.findAllWithDetail();
        listContacts(contacts);

    }

    private static void listContacts(List<Contact> contacts) {
        for (Contact contact: contacts) {
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
