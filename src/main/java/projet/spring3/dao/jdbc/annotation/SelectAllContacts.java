package projet.spring3.dao.jdbc.annotation;

import org.springframework.jdbc.object.MappingSqlQuery;
import projet.spring3.domain.Contact;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectAllContacts extends MappingSqlQuery {

    private static final String SQL_SELECT_ALL_CONTACT = "select id, first_name, last_name, birth_date from contact";

    public SelectAllContacts(DataSource dataSource) {
        super(dataSource, SQL_SELECT_ALL_CONTACT);
    }


    @Override
    protected Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Contact contact = new Contact();

        contact.setId(rs.getLong("id"));
        contact.setFirstName(rs.getString("first_name"));
        contact.setLastName(rs.getString("last_name"));
        contact.setBirthDate(rs.getDate("birth_date"));

        return contact;
    }
}
