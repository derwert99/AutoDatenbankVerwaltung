import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccessFahrzeuge {

    private static String automodellePfad = "source/DataStore/automodelle.db";
    private static String motorradmodellePfad = "source/DataStore/motorradmodelle.db";
    private List<Motorradmodell> motorradmodelleList;
    private List<Automodell> automodelleList;

    Scanner scanner = new Scanner(System.in);

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

    public void aktualisiereMotorradmodell() {
        for (Motorradmodell motorradmodell : motorradmodelleList) {
            System.out.println(motorradmodell.getKennzeichen());
        }

        System.out.print("Welche Kennzeichen möchten Sie aktualisieren: ");
        String kennzeichen = scanner.nextLine();

        boolean found = false;
        for (Motorradmodell motorradmodell : motorradmodelleList) {
            if (kennzeichen.equals(motorradmodell.getKennzeichen())) {
                found = true;

                System.out.println("Aktuelle Werte:");
                System.out.println("1. Marke: " + motorradmodell.getMarke());
                System.out.println("2. Modell: " + motorradmodell.getModell());
                System.out.println("3. Farbe: " + motorradmodell.getFarbe());
                System.out.println("4. PS: " + motorradmodell.getPs());
                System.out.println("5. Kraftstoff: " + motorradmodell.getKraftstoff());
                System.out.println("6. Getriebe: " + motorradmodell.getGetriebe());

                System.out.println("Welches Attribut möchten Sie ändern (1-6): ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Clear the newline character

                switch (choice) {
                    case 1:
                        System.out.print("Neue Marke eingeben: ");
                        String neueMarke = scanner.nextLine();
                        motorradmodell.setMarke(neueMarke);
                        break;
                    case 2:
                        System.out.print("Neues Modell eingeben: ");
                        String neuesModell = scanner.nextLine();
                        motorradmodell.setModell(neuesModell);
                        break;
                    case 3:
                        System.out.print("Neue Farbe eingeben: ");
                        String neueFarbe = scanner.nextLine();
                        motorradmodell.setFarbe(neueFarbe);
                        break;
                    case 4:
                        System.out.print("Neue PS eingeben: ");
                        int neuePs = scanner.nextInt();
                        scanner.nextLine();
                        motorradmodell.setPs(neuePs);
                        break;
                    case 5:
                        System.out.print("Neuen Kraftstoff eingeben: ");
                        String neuerKraftstoff = scanner.nextLine();
                        motorradmodell.setKraftstoff(neuerKraftstoff);
                        break;
                    case 6:
                        System.out.print("Neues Getriebe eingeben: ");
                        String neuesGetriebe = scanner.nextLine();
                        motorradmodell.setGetriebe(neuesGetriebe);
                        break;
                    default:
                        System.out.println("Ungültige Auswahl.");
                }
                break; // Exit the loop after updating
            }
        }

        if (!found) {
            System.out.println("Motorradmodell mit dem angegebenen Kennzeichen nicht gefunden.");
        }
    }


    // todo muss noch korrigiert werden

    public void aktualisiereAutomodell() {
        for (Automodell automodell : automodelleList) {
            System.out.println(automodell.getKennzeichen());
        }

        System.out.print("Welche Kennzeichen möchten Sie aktualisieren: ");
        String kennzeichen = scanner.nextLine();

        boolean found = false;
        for (Automodell automodell : automodelleList) {
            if (kennzeichen.equals(automodell.getKennzeichen())) {
                found = true;

                System.out.println("Aktuelle Werte:");
                System.out.println("1. Marke: " + automodell.getMarke());
                System.out.println("2. Modell: " + automodell.getModell());
                System.out.println("3. Farbe: " + automodell.getFarbe());
                System.out.println("4. PS: " + automodell.getPs());
                System.out.println("5. Kraftstoff: " + automodell.getKraftstoff());
                System.out.println("6. Getriebe: " + automodell.getGetriebe());

                System.out.println("Welches Attribut möchten Sie ändern (1-6): ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Clear the newline character

                switch (choice) {
                    case 1:
                        System.out.print("Neue Marke eingeben: ");
                        String neueMarke = scanner.nextLine();
                        automodell.setMarke(neueMarke);
                        break;
                    case 2:
                        System.out.print("Neues Modell eingeben: ");
                        String neuesModell = scanner.nextLine();
                        automodell.setModell(neuesModell);
                        break;
                    case 3:
                        System.out.print("Neue Farbe eingeben: ");
                        String neueFarbe = scanner.nextLine();
                        automodell.setFarbe(neueFarbe);
                        break;
                    case 4:
                        System.out.print("Neue PS eingeben: ");
                        int neuePs = scanner.nextInt();
                        scanner.nextLine();
                        automodell.setPs(neuePs);
                        break;
                    case 5:
                        System.out.print("Neuen Kraftstoff eingeben: ");
                        String neuerKraftstoff = scanner.nextLine();
                        automodell.setKraftstoff(neuerKraftstoff);
                        break;
                    case 6:
                        System.out.print("Neues Getriebe eingeben: ");
                        String neuesGetriebe = scanner.nextLine();
                        automodell.setGetriebe(neuesGetriebe);
                        break;
                    default:
                        System.out.println("Ungültige Auswahl.");
                }
                break; // Exit the loop after updating
            }
        }

        if (!found) {
            System.out.println("Automodell mit dem angegebenen Kennzeichen nicht gefunden.");
        }
    }

    public void loescheMotorradmodell() {
        System.out.print("Gib Kennzeichen ein um Motorrad zu löschen: ");
        Scanner scanner = new Scanner(System.in);
        String kennzeichen = scanner.nextLine();

        for (Motorradmodell motorradmodell : motorradmodelleList){
            if (kennzeichen.equals(motorradmodell.getKennzeichen())){
                motorradmodelleList.remove(motorradmodell);
            }
            else {
                System.out.println("Kennzeichen nicht gefunden");
            }
        }


    }

    public void loescheAutomodell() {
        System.out.print("Gib Kennzeichen ein um Auto zu löschen: ");
        Scanner scanner = new Scanner(System.in);
        String kennzeichen = scanner.nextLine();

        for (Automodell automodell: automodelleList){
            if (kennzeichen.equals(automodell.getKennzeichen())){
                automodelleList.remove(automodell);
            }
            else {
                System.out.println("Auto wurde nicht gefunden");
            }
        }


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
        scanner.nextLine();
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
