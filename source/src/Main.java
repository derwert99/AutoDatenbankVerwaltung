import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        short attemptTickets = 3;
        boolean loggedIn = false;

        while (!(attemptTickets == 0) && !loggedIn) {
            System.out.print("Bitte geben Sie Ihren Benutzernamen ein:");
            String username = scanner.nextLine();
            System.out.print("Bitte geben Sie Ihr Passwort ein:");
            String password = scanner.nextLine();

            if (AccessCredentials.checkCredentials(username, password)) {
                loggedIn = true;
            } else {
                attemptTickets--;
                System.out.println("Benutzername oder Passwort falsch. Versuche übrig: " + attemptTickets);
            }
        }

        DatenbankManager datenbankManager = new DatenbankManager();
        datenbankManager.ladeDatenbank();

        boolean exitProgramm = false;

        if (loggedIn) {
            while (!exitProgramm) {
                System.out.println("Bitte wählen Sie eine Aktion:");
                System.out.println("1. Automodell erstellen");
                System.out.println("2. Motorradmodell erstellen");
                System.out.println("3. Automodell aktualisieren");
                System.out.println("4. Motorradmodell aktualisieren");
                System.out.println("5. Automodell löschen");
                System.out.println("6. Motorradmodell löschen");
                System.out.println("7. Automodell suchen");
                System.out.println("8. Motorradmodell suchen");
                System.out.println("9. Programm beenden");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Clear the newline character

                switch (choice) {
                    case 1:
                        datenbankManager.getAccessFahrzeuge().erstelleAutomodell();
                        break;
                    case 2:
                        datenbankManager.getAccessFahrzeuge().erstelleMotorradmodell();
                        break;
                    case 3:
                        datenbankManager.getAccessFahrzeuge().aktualisiereAutomodell();
                        break;
                    case 4:
                        datenbankManager.getAccessFahrzeuge().aktualisiereMotorradmodell();
                        break;
                    case 5:
                        datenbankManager.getAccessFahrzeuge().loescheAutomodell();
                        break;
                    case 6:
                        datenbankManager.getAccessFahrzeuge().loescheMotorradmodell();
                        break;
                    case 7:
                        datenbankManager.getAccessFahrzeuge().sucheAutomodell();
                        break;
                    case 8:
                        datenbankManager.getAccessFahrzeuge().sucheMotorradmodell();
                        break;
                    case 9:
                        exitProgramm = true;
                        break;
                    default:
                        System.out.println("Ungültige Auswahl. Bitte geben Sie eine Zahl zwischen 1 und 9 ein.");
                }
            }


            datenbankManager.speichereDatenbank();
        }
    }
}
