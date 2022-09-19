package basedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public class PostgreSQLJDBC {

    private final String host = "localhost";
    private final String port = "5432";
    private final String database = "sysgai";
    private final String url = "jdbc:postgresql://" + host + ":" + port + "/" + database;
    private final String user = "odoo";
    private final String password = "odoo";

    public Connection connect() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return connection;
    }
}
