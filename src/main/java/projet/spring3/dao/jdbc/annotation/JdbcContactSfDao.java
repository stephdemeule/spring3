package projet.spring3.dao.jdbc.annotation;

import org.springframework.stereotype.Repository;
import projet.spring3.dao.ContactSfDao;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;

@Repository("contactSfDao")
public class JdbcContactSfDao implements ContactSfDao {

    private DataSource dataSource;

    private SfFirstNameById sfFirstNameById;

    @Resource(name="dataSource")
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;

        sfFirstNameById = new SfFirstNameById(dataSource);
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public String getFirstNameById(Long id) {
        List<String> result = sfFirstNameById.execute(id);
        return result.get(0);
    }
}
