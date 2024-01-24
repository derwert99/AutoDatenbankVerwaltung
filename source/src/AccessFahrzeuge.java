import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccessFahrzeuge {

    private static String automodellePfad = "source/DataStore/automodelle.db";
    private static String motorradmodellePfad = "source/DataStore/motorradmodelle.db";
    private List<Motorradmodell> motorradmodelleList;
    private List<Automodell> automodelleList;

    public AccessFahrzeuge() {
        this.motorradmodelleList = new ArrayList<>();
        this.automodelleList = new ArrayList<>();
    }

    public List<Motorradmodell> ladeMotorradmodelle() {
        List<Motorradmodell> motorradmodelle = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:" + motorradmodellePfad);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM Motorradmodelle")) {

            while (resultSet.next()) {
                String kennzeichen = resultSet.getString("Kennzeichen");
                String marke = resultSet.getString("Marke");
                String modell = resultSet.getString("Modell");
                String farbe = resultSet.getString("Farbe");
                int ps = resultSet.getInt("PS");
                String kraftstoff = resultSet.getString("Kraftstoff");
                String getriebe = resultSet.getString("Getriebe");

                Motorradmodell motorradmodell = new Motorradmodell(kennzeichen, marke, modell, farbe, ps, kraftstoff, getriebe);
                motorradmodelle.add(motorradmodell);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return motorradmodelle;
    }

    public List<Automodell> ladeAutomodelle() {
        List<Automodell> automodelle = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:" + automodellePfad);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM Automodelle")) {

            while (resultSet.next()) {
                String kennzeichen = resultSet.getString("Kennzeichen");
                String marke = resultSet.getString("Marke");
                String modell = resultSet.getString("Modell");
                String farbe = resultSet.getString("Farbe");
                int ps = resultSet.getInt("PS");
                String kraftstoff = resultSet.getString("Kraftstoff");
                String getriebe = resultSet.getString("Getriebe");

                Automodell automodell = new Automodell(kennzeichen, marke, modell, farbe, ps, kraftstoff, getriebe);
                automodelle.add(automodell);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return automodelle;
    }

    public void speichereMotorradmodelle(List<Motorradmodell> motorradmodelle) {
        String deleteSql = "DELETE FROM Motorradmodelle";
        String insertSql = "INSERT INTO Motorradmodelle VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:" + motorradmodellePfad);
             PreparedStatement deleteStatement = connection.prepareStatement(deleteSql);
             PreparedStatement insertStatement = connection.prepareStatement(insertSql)) {

            deleteStatement.executeUpdate();

            for (Motorradmodell motorradmodell : motorradmodelle) {
                insertStatement.setString(1, motorradmodell.getKennzeichen());
                insertStatement.setString(2, motorradmodell.getMarke());
                insertStatement.setString(3, motorradmodell.getModell());
                insertStatement.setString(4, motorradmodell.getFarbe());
                insertStatement.setInt(5, motorradmodell.getPs());
                insertStatement.setString(6, motorradmodell.getKraftstoff());
                insertStatement.setString(7, motorradmodell.getGetriebe());

                insertStatement.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void speichereAutomodelle(List<Automodell> automodelle) {
        String deleteSql = "DELETE FROM Automodelle";
        String insertSql = "INSERT INTO Automodelle VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:" + automodellePfad);
             PreparedStatement deleteStatement = connection.prepareStatement(deleteSql);
             PreparedStatement insertStatement = connection.prepareStatement(insertSql)) {

            deleteStatement.executeUpdate();

            for (Automodell automodell : automodelle) {
                insertStatement.setString(1, automodell.getKennzeichen());
                insertStatement.setString(2, automodell.getMarke());
                insertStatement.setString(3, automodell.getModell());
                insertStatement.setString(4, automodell.getFarbe());
                insertStatement.setInt(5, automodell.getPs());
                insertStatement.setString(6, automodell.getKraftstoff());
                insertStatement.setString(7, automodell.getGetriebe());

                insertStatement.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // todo muss noch korrigiert werden

    public void aktualisiereMotorradmodell(String kennzeichen, String neueMarke, String neuesModell) {


        for (Motorradmodell motorradmodell : motorradmodelleList){
            if (kennzeichen.equals(motorradmodell.getKennzeichen())){
                motorradmodell.setMarke(neueMarke);
                motorradmodell.setModell(neuesModell);
            }
        }

//        String selectSql = "SELECT * FROM Motorradmodelle WHERE Kennzeichen = ?";
//        String updateSql = "UPDATE Motorradmodelle SET Marke = ?, Modell = ? WHERE Kennzeichen = ?";

//        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:" + motorradmodellePfad);
//             PreparedStatement selectStatement = connection.prepareStatement(selectSql);
//             PreparedStatement updateStatement = connection.prepareStatement(updateSql)) {
//
//            selectStatement.setString(1, kennzeichen);
//
//            try (ResultSet resultSet = selectStatement.executeQuery()) {
//                if (resultSet.next()) {
//                    updateStatement.setString(1, neueMarke);
//                    updateStatement.setString(2, neuesModell);
//                    updateStatement.setString(3, kennzeichen);
//
//                    int affectedRows = updateStatement.executeUpdate();
//
//                    if (affectedRows > 0) {
//                        System.out.println("Motorradmodell erfolgreich aktualisiert.");
//                    } else {
//                        System.out.println("Fehler beim Aktualisieren des Motorradmodells.");
//                    }
//                } else {
//                    System.out.println("Motorradmodell mit dem angegebenen Kennzeichen nicht gefunden.");
//                }
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    // todo muss noch korrigiert werden

    public void aktualisiereAutomodell(String kennzeichen, String neueMarke, String neuesModell) {

        for (Automodell automodell: automodelleList){
            if (kennzeichen.equals(automodell.getKennzeichen())){
                automodell.setMarke(neueMarke);
                automodell.setModell(neuesModell);
            }
        }

//        String selectSql = "SELECT * FROM Automodelle WHERE Kennzeichen = ?";
//        String updateSql = "UPDATE Automodelle SET Marke = ?, Modell = ? WHERE Kennzeichen = ?";
//
//        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:" + automodellePfad);
//             PreparedStatement selectStatement = connection.prepareStatement(selectSql);
//             PreparedStatement updateStatement = connection.prepareStatement(updateSql)) {
//
//            selectStatement.setString(1, kennzeichen);
//
//            try (ResultSet resultSet = selectStatement.executeQuery()) {
//                if (resultSet.next()) {
//                    updateStatement.setString(1, neueMarke);
//                    updateStatement.setString(2, neuesModell);
//                    updateStatement.setString(3, kennzeichen);
//
//                    int affectedRows = updateStatement.executeUpdate();
//
//                    if (affectedRows > 0) {
//                        System.out.println("Automodell erfolgreich aktualisiert.");
//                    } else {
//                        System.out.println("Fehler beim Aktualisieren des Automodells.");
//                    }
//                } else {
//                    System.out.println("Automodell mit dem angegebenen Kennzeichen nicht gefunden.");
//                }
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    public void loescheMotorradmodell(String kennzeichen) {

        for (Motorradmodell motorradmodell : motorradmodelleList){
            if (kennzeichen.equals(motorradmodell.getKennzeichen())){
                motorradmodelleList.remove(motorradmodell);
            }
        }


//        String deleteSql = "DELETE FROM Motorradmodelle WHERE Kennzeichen = ?";
//
//        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:" + motorradmodellePfad);
//             PreparedStatement preparedStatement = connection.prepareStatement(deleteSql)) {
//
//            preparedStatement.setString(1, kennzeichen);
//            int rowsAffected = preparedStatement.executeUpdate();
//
//            if (rowsAffected > 0) {
//                System.out.println("Motorradmodell erfolgreich gelöscht.");
//            } else {
//                System.out.println("Motorradmodell mit dem angegebenen Kennzeichen wurde nicht gefunden.");
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    public void loescheAutomodell(String kennzeichen) {


        for (Automodell automodell: automodelleList){
            if (kennzeichen.equals(automodell.getKennzeichen())){
                automodelleList.remove(automodell);
            }
        }

//        String deleteSql = "DELETE FROM Automodelle WHERE Kennzeichen = ?";
//
//        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:" + automodellePfad);
//             PreparedStatement preparedStatement = connection.prepareStatement(deleteSql)) {
//
//            preparedStatement.setString(1, kennzeichen);
//            int rowsAffected = preparedStatement.executeUpdate();
//
//            if (rowsAffected > 0) {
//                System.out.println("Automodell erfolgreich gelöscht.");
//            } else {
//                System.out.println("Automodell mit dem angegebenen Kennzeichen wurde nicht gefunden.");
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    public void erstelleMotorradmodell() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bitte geben Sie das Kennzeichen des Motorradmodells ein:");
        String kennzeichen = scanner.nextLine();
        System.out.print("Bitte geben Sie die Marke des Motorradmodells ein:");
        String marke = scanner.nextLine();
        System.out.print("Bitte geben Sie das Modell des Motorradmodells ein:");
        String modell = scanner.nextLine();
        System.out.print("Bitte geben Sie die Farbe des Motorradmodells ein:");
        String farbe = scanner.nextLine();
        System.out.print("Bitte geben Sie die PS des Motorradmodells ein:");
        int ps = scanner.nextInt();
        scanner.nextLine(); // Clear the newline character
        System.out.print("Bitte geben Sie den Kraftstoff des Motorradmodells ein:");
        String kraftstoff = scanner.nextLine();
        System.out.print("Bitte geben Sie das Getriebe des Motorradmodells ein:");
        String getriebe = scanner.nextLine();

        Motorradmodell motorradmodell = new Motorradmodell(kennzeichen, marke, modell, farbe, ps, kraftstoff, getriebe);
        motorradmodelleList.add(motorradmodell);
        System.out.println("Motorradmodell erfolgreich erstellt.");
    }

    public void erstelleAutomodell() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bitte geben Sie das Kennzeichen des Automodells ein:");
        String kennzeichen = scanner.nextLine();
        System.out.print("Bitte geben Sie die Marke des Automodells ein:");
        String marke = scanner.nextLine();
        System.out.print("Bitte geben Sie das Modell des Automodells ein:");
        String modell = scanner.nextLine();
        System.out.print("Bitte geben Sie die Farbe des Automodells ein:");
        String farbe = scanner.nextLine();
        System.out.print("Bitte geben Sie die PS des Automodells ein:");
        int ps = scanner.nextInt();
        scanner.nextLine(); // Clear the newline character
        System.out.print("Bitte geben Sie den Kraftstoff des Automodells ein:");
        String kraftstoff = scanner.nextLine();
        System.out.print("Bitte geben Sie das Getriebe des Automodells ein:");
        String getriebe = scanner.nextLine();

        Automodell automodell = new Automodell(kennzeichen, marke, modell, farbe, ps, kraftstoff, getriebe);
        automodelleList.add(automodell);
        System.out.println("Automodell erfolgreich erstellt.");
    }

    public void sucheMotorradmodell() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bitte geben Sie das Kennzeichen des zu suchenden Motorradmodells ein:");
        String kennzeichen = scanner.nextLine();

        for (Motorradmodell motorradmodell : motorradmodelleList) {
            if (motorradmodell.getKennzeichen().equals(kennzeichen)) {
                System.out.println("Gefundenes Motorradmodell:");
                System.out.println(motorradmodell);
                return;
            }
        }

        System.out.println("Motorradmodell mit dem angegebenen Kennzeichen nicht gefunden.");
    }

    public void sucheAutomodell() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bitte geben Sie das Kennzeichen des zu suchenden Automodells ein:");
        String kennzeichen = scanner.nextLine();

        for (Automodell automodell : automodelleList) {
            if (automodell.getKennzeichen().equals(kennzeichen)) {
                System.out.println("Gefundenes Automodell:");
                System.out.println(automodell);
                return;
            }
        }

        System.out.println("Automodell mit dem angegebenen Kennzeichen nicht gefunden.");
    }

    // Weitere Methoden hier...
}
