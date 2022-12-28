package projet.spring3.dao.jdbc.annotation;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlFunction;

import javax.sql.DataSource;
import java.sql.Types;

public class SfFirstNameById extends SqlFunction<String> {
    private static final String SQL = "select getfirstnamebyid(?)";

    public SfFirstNameById(DataSource dataSource) {
        super(dataSource, SQL);
        declareParameter(new SqlParameter(Types.INTEGER));
        compile();
    }
}
