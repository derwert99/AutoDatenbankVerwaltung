import java.sql.*;

public class AccessCredentials {


    public static boolean checkCredentials(String username, String password) {

        String credentialsPfad = "C:\\Users\\43660\\OneDrive - Fachhochschule Burgenland GmbH\\Semester 3\\Programmiertechniken\\Gruppenarbeit\\Git\\AutoDatenbankVerwaltung\\source\\DataStore\\credentials.db";

        //Verfügbare Credentials, es sei denn, jemand hat andere hinzugefügt
        // Thomas Kirschner|password123
        // Benjamin Böhm|password123

        String jdbcUrl = "jdbc:sqlite:" + credentialsPfad;

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
