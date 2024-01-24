import java.sql.*;

public class AccessCredentials {

    public static boolean checkCredentials(String username, String password) {

        // Pfad zur credentials.db-Datei
        String dbPath = "source/DataStore/credentials.db";

        // Laden der JDBC-Treiberklasse
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }

        String jdbcUrl = "jdbc:sqlite:" + dbPath;

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
