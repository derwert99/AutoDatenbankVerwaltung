import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class AccessFahrzeuge {





    private static String automodellePfad ="C:\\Users\\43660\\OneDrive - Fachhochschule Burgenland GmbH\\Semester 3\\Programmiertechniken\\Gruppenarbeit\\Git\\AutoDatenbankVerwaltung\\source\\DataStore\\automodelle.db";

    private static String motorradmodellePfad = "C:\\Users\\43660\\OneDrive - Fachhochschule Burgenland GmbH\\Semester 3\\Programmiertechniken\\Gruppenarbeit\\Git\\AutoDatenbankVerwaltung\\source\\DataStore\\motorradmodelle.db";



//    public static void accessMotorradmodell(String nummertafel) {
//    }
//
//    public static void accessAutomodell(String nummertafel) {
//    }
//
//    public static void deleteMotorradmodell(String nummertafel) {
//    }
//
//    public static void deleteAutomodell(String nummertafel) {
//    }


    // todo methoden nach benjis menu
    public static void create (){}
    public static void read (){}
    public static void  update (){}
    public static void delete (){}

//    public static List<Automodell> loadAutomodelle(List<Automodell> automodelleList) throws SQLException {
//
//        // schema der Datenbank:
//        // Automodelle (Automarke varchar(25),Automodell varchar(25), Farbe varchar(15), Kraftstoff varchar(15), Getriebe varchar(30),ps int);
//
//        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:" + automodellePfad);
//             PreparedStatement preparedStatement = ((java.sql.Connection) connection).prepareStatement("SELECT * FROM Automodelle");
//             ResultSet resultSet = preparedStatement.executeQuery()) {
//
//            while (resultSet.next()) {
//                String automarke = resultSet.getString("Automarke");
//                String automodell = resultSet.getString("Automodell");
//                String farbe = resultSet.getString("Farbe");
//                String kraftstoff = resultSet.getString("Kraftstoff");
//                String getriebe = resultSet.getString("Getriebe");
//                int ps = resultSet.getInt("ps");
//
//                Automodell automodellObj = new Automodell(automarke, automodell, farbe, kraftstoff, getriebe, ps);
//                automodelleList.add(automodellObj);
//
//                // Ausgabe als Beispiel
//                System.out.println("Automodell: " + automodellObj.getAutomodell());
//            }
//        }
//        return automodelleList;
//    }

//    public static List<Motorradmodell> loadMotorradmodelle(List<Motorradmodell> motorradmodellList) throws SQLException {
//
////        schema der Datenbank
////        Motorradmodelle (Motorradmarke varchar(25), Motorradmodell varchar(25), Farbe varchar(15), Kraftstoff varchar(15), Getriebe varchar(30), ps int);
//
//
//        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:" + motorradmodellePfad);
//             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Motorradmodelle");
//             ResultSet resultSet = preparedStatement.executeQuery()) {
//
//            while (resultSet.next()) {
//                String motorradmarke = resultSet.getString("Motorradmarke");
//                String motorradmodell = resultSet.getString("Motorradmodell");
//                String farbe = resultSet.getString("Farbe");
//                String kraftstoff = resultSet.getString("Kraftstoff");
//                String getriebe = resultSet.getString("Getriebe");
//                int ps = resultSet.getInt("ps");
//
//                Motorradmodell motorradmodellObj = new Motorradmodell(motorradmarke, motorradmodell, farbe, kraftstoff, getriebe, ps);
//                motorradmodellList.add(motorradmodellObj);
//
//                // Ausgabe als Beispiel
//                System.out.println("Motorradmodell: " + motorradmodellObj.getMotorradmodell());
//            }
//        }
//        return motorradmodellList;
//    }


    //Todo remove Lists

    public static List<GeparkteAutos> loadGeparkteAutos(List<GeparkteAutos> geparkteAutosList) throws SQLException {

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:" + geparkteAutosPfad);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM GeparkteAutos")) {

            while (resultSet.next()) {
                String nummertafel = resultSet.getString("Nummertafel");
                String automodell = resultSet.getString("Automodell");

                GeparkteAutos geparktesAuto = new GeparkteAutos(nummertafel, automodell);
                geparkteAutosList.add(geparktesAuto);
            }
        }

        return geparkteAutosList;
    }

//    public static List<GeparkteMotorrader> loadGeparkteMotorrader(List<GeparkteMotorrader> geparkteMotorraderList) throws SQLException {
//
//        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:" + geparkteMotorraderPfad);
//             Statement statement = connection.createStatement();
//             ResultSet resultSet = statement.executeQuery("SELECT * FROM GeparkteMotorrader")) {
//
//            while (resultSet.next()) {
//                String nummertafel = resultSet.getString("Nummertafel");
//                String motorradmodell = resultSet.getString("Motorradmodell");
//
//                GeparkteMotorrader geparktesMotorrad = new GeparkteMotorrader(nummertafel, motorradmodell);
//                geparkteMotorraderList.add(geparktesMotorrad);
//            }
//        }
//
//        return geparkteMotorraderList;
//    }



    public static void autoParken(List<Automodell> automodelleList) throws SQLException {

        //Datenbank Schema  create table GeparkteAutos (Nummertafel varchar(25), Autmodell varchar(25));
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bitte geben Sie die Nummertafel ein:");
        String nummertafel = scanner.nextLine();

        boolean gueltigeAuswahl = false;
        String auswahl = "";

        while (!gueltigeAuswahl) {
            System.out.println("Wählen Sie das Automodell aus: ");

            for (Automodell automodell : automodelleList) {
                System.out.println(automodell.getAutomodell());
            }

            auswahl = scanner.nextLine();

            String finalAuswahl = auswahl;
            gueltigeAuswahl = automodelleList.stream().anyMatch(automodell -> automodell.getAutomodell().equalsIgnoreCase(finalAuswahl));

            if (!gueltigeAuswahl) {
                System.out.println("Ungültige Auswahl. Bitte wählen Sie erneut.");
            } else {
                try (Connection connection = DriverManager.getConnection("jdbc:sqlite:" + geparkteAutosPfad)) {
                    String insertQuery = "INSERT INTO GeparkteAutos (Nummertafel, Automodell) VALUES (?, ?)";
                    try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                        preparedStatement.setString(1, nummertafel);
                        preparedStatement.setString(2, auswahl);

                        int affectedRows = preparedStatement.executeUpdate();

                        if (affectedRows > 0) {
                            System.out.println("Auto erfolgreich geparkt und in die Datenbank eingefügt.");

                        } else {
                            System.out.println("Fehler beim Einfügen in die Datenbank.");
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void motorradParken(List<Motorradmodell> motorradmodellList) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bitte geben Sie die Nummertafel ein:");
        String nummertafel = scanner.nextLine();

        boolean gueltigeAuswahl = false;
        String auswahl = "";

        while (!gueltigeAuswahl) {
            System.out.println("Wählen Sie das Motorradmodell aus: ");

            for (Motorradmodell motorradmodell : motorradmodellList) {
                System.out.println(motorradmodell.getMotorradmodell());
            }

            auswahl = scanner.nextLine();

            String finalAuswahl = auswahl;
            gueltigeAuswahl = motorradmodellList.stream().anyMatch(motorradmodell ->
                    motorradmodell.getMotorradmodell().equalsIgnoreCase(finalAuswahl));

            if (!gueltigeAuswahl) {
                System.out.println("Ungültige Auswahl. Bitte wählen Sie erneut.");
            } else {
                try (Connection connection = DriverManager.getConnection("jdbc:sqlite:" + geparkteMotorraderPfad)) {
                    String insertQuery = "INSERT INTO GeparkteMotorrader (Nummertafel, Motorradmodell) VALUES (?, ?)";
                    try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                        preparedStatement.setString(1, nummertafel);
                        preparedStatement.setString(2, auswahl);

                        int affectedRows = preparedStatement.executeUpdate();

                        if (affectedRows > 0) {
                            System.out.println("Motorrad erfolgreich geparkt und in die Datenbank eingefügt.");
                        } else {
                            System.out.println("Fehler beim Einfügen in die Datenbank.");
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }




    // todo muss der Klasse Autmodell und Benjis menu dementsprechend angepasst werden

    public static void automodellErstellen() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bitte geben Sie die Eigenschaften für das neue Automodell ein:");

        System.out.print("Automarke: ");
        String automarke = scanner.nextLine();

        System.out.print("Automodell: ");
        String automodell = scanner.nextLine();

        System.out.print("Farbe: ");
        String farbe = scanner.nextLine();

        System.out.print("Kraftstoff: ");
        String kraftstoff = scanner.nextLine();

        System.out.print("Getriebe: ");
        String getriebe = scanner.nextLine();

        System.out.print("PS: ");
        int ps = scanner.nextInt();
        scanner.nextLine();




        Automodell neuesAutomodell = new Automodell(automarke, automodell, farbe, kraftstoff, getriebe, ps);


        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:C:" + automodellePfad);
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Automodelle VALUES (?, ?, ?, ?, ?, ?)")) {

            preparedStatement.setString(1, neuesAutomodell.getAutomarke());
            preparedStatement.setString(2, neuesAutomodell.getAutomodell());
            preparedStatement.setString(3, neuesAutomodell.getFarbe());
            preparedStatement.setString(4, neuesAutomodell.getKraftstoff());
            preparedStatement.setString(5, neuesAutomodell.getGetriebe());
            preparedStatement.setInt(6, neuesAutomodell.getPs());

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Automodell erfolgreich erstellt und in die Datenbank eingefügt.");
            } else {
                System.out.println("Fehler beim Einfügen in die Datenbank.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    // todo muss der Klasse Motorradmodel und Benjis menu dementsprechend angepasst werden
    public static void motorradmodellErstellen() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Bitte geben Sie die Eigenschaften für das neue Motorradmodell ein:");

        System.out.print("Motorradmarke: ");
        String motorradmarke = scanner.nextLine();

        System.out.print("Motorradmodell: ");
        String motorradmodell = scanner.nextLine();

        System.out.print("Farbe: ");
        String farbe = scanner.nextLine();

        System.out.print("Kraftstoff: ");
        String kraftstoff = scanner.nextLine();

        System.out.print("Getriebe: ");
        String getriebe = scanner.nextLine();

        System.out.print("PS: ");
        int ps = scanner.nextInt();
        scanner.nextLine(); // Leeren Sie den Scanner-Puffer

        // Erstellen Sie das Motorradmodell-Objekt
        Motorradmodell neuesMotorradmodell = new Motorradmodell(motorradmarke, motorradmodell, farbe, kraftstoff, getriebe, ps);

        // Fügen Sie das Motorradmodell in die Datenbank ein
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:C:" + motorradmodellePfad);
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Motorradmodelle VALUES (?, ?, ?, ?, ?, ?)")) {

            preparedStatement.setString(1, neuesMotorradmodell.getMotorradmarke());
            preparedStatement.setString(2, neuesMotorradmodell.getMotorradmodell());
            preparedStatement.setString(3, neuesMotorradmodell.getFarbe());
            preparedStatement.setString(4, neuesMotorradmodell.getKraftstoff());
            preparedStatement.setString(5, neuesMotorradmodell.getGetriebe());
            preparedStatement.setInt(6, neuesMotorradmodell.getPs());

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Motorradmodell erfolgreich erstellt und in die Datenbank eingefügt.");
            } else {
                System.out.println("Fehler beim Einfügen in die Datenbank.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // todo weiß noch nicht ob behalten werden soll - eventuell remove

    public static void autoAusparken(List<GeparkteAutos> geparkteAutosList) {

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:" + geparkteAutosPfad)) {

            System.out.println("Folgende Autos sind geparkt:");
            for (GeparkteAutos geparktesAuto : geparkteAutosList) {
                System.out.println("Nummertafel: " + geparktesAuto.getNummertafel() + ", Automodell: " + geparktesAuto.getAutomodell());
            }

            Scanner scanner = new Scanner(System.in);
            System.out.print("Geben Sie die Nummertafel des zu entfernenden Autos ein: ");
            String nummertafelToRemove = scanner.nextLine();

            // Überprüfen, ob die eingegebene Nummertafel existiert
            boolean found = geparkteAutosList.stream()
                    .anyMatch(auto -> auto.getNummertafel().equalsIgnoreCase(nummertafelToRemove));

            if (found) {
                String deleteQuery = "DELETE FROM GeparkteAutos WHERE Nummertafel = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
                    preparedStatement.setString(1, nummertafelToRemove);

                    int affectedRows = preparedStatement.executeUpdate();

                    if (affectedRows > 0) {
                        System.out.println("Auto erfolgreich aus der Garage entfernt.");
                    } else {
                        System.out.println("Fehler beim Entfernen des Autos aus der Garage.");
                    }
                }
            } else {
                System.out.println("Die eingegebene Nummertafel wurde nicht gefunden.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

// todo weiß nicht ob behalten werden soll - eventuell remove
    public static void motorradAusparken(List<GeparkteMotorrader> geparkteMotorraderList) {

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:" + geparkteMotorraderPfad)) {

            System.out.println("Folgende Motorräder sind geparkt:");
            for (GeparkteMotorrader geparktesMotorrad : geparkteMotorraderList) {
                System.out.println("Nummertafel: " + geparktesMotorrad.getNummertafel() +
                        ", Motorradmodell: " + geparktesMotorrad.getMotorradmodell());
            }

            Scanner scanner = new Scanner(System.in);
            System.out.print("Geben Sie die Nummertafel des zu entfernenden Motorrads ein: ");
            String nummertafelToRemove = scanner.nextLine();

            // Überprüfen, ob die eingegebene Nummertafel existiert
            boolean found = geparkteMotorraderList.stream()
                    .anyMatch(motorrad -> motorrad.getNummertafel().equalsIgnoreCase(nummertafelToRemove));

            if (found) {
                String deleteQuery = "DELETE FROM GeparkteMotorrader WHERE Nummertafel = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
                    preparedStatement.setString(1, nummertafelToRemove);

                    int affectedRows = preparedStatement.executeUpdate();

                    if (affectedRows > 0) {
                        System.out.println("Motorrad erfolgreich aus der Garage entfernt.");
                    } else {
                        System.out.println("Fehler beim Entfernen des Motorrads aus der Garage.");
                    }
                }
            } else {
                System.out.println("Die eingegebene Nummertafel wurde nicht gefunden.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}



