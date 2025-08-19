package literalura;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static final String URL = "jdbc:h2:./literalura";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Error al conectar a la base de datos", e);
        }
    }
    public static void init() {
        String sql = """
        CREATE TABLE IF NOT EXISTS books (
            id INT PRIMARY KEY,
            title VARCHAR(200),
            author VARCHAR(200)
        );
        """;

        try (var conn = getConnection();
             var stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException("Error creando tabla", e);
        }
    }

}
