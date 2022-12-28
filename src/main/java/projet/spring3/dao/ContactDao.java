package projet.spring3.dao;

import projet.spring3.domain.Contact;

import java.util.List;

public interface ContactDao {
    public String findFirstNameById(Long id);

    public List<Contact> findAll();

    public List<Contact> findByFirstName(String firstName);

    public void insert(Contact contact);

    public void update(Contact contact);

    public void delete(Long contactId);

    List<Contact> findAllWithDetail();

    public void insertWithDetail(Contact contact);
}
