import java.io.InputStream;
import java.sql.*;

public class AccessCredentials {


    public static boolean checkCredentials(String username, String password) {

        InputStream credentialsStream = AccessCredentials.class.getClassLoader().getResourceAsStream("DataStore/credentials.db");

        if (credentialsStream == null) {
            System.err.println("Fehler beim Laden der credentials.db-Datei.");
            return false;
        }


        //Verfügbare Credentials, es sei denn, jemand hat andere hinzugefügt
        // Thomas Kirschner|password123
        // Benjamin Böhm|password123

        String jdbcUrl = "jdbc:sqlite::memory:";

        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";

        try (Connection connection = DriverManager.getConnection(jdbcUrl);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                System.out.println("Zugriff gewährt. Willkommen, " + username + "!");
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

}
