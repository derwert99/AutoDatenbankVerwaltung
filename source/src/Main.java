import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
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



        ArrayList<Motorradmodell> motorradmodelleList = new ArrayList<>();
        ArrayList<Automodell> automodelleList = new ArrayList<>();


        AccessFahrzeuge accessFahrzeuge = new AccessFahrzeuge();
        accessFahrzeuge.ladeMotorradmodelle(motorradmodelleList);
        accessFahrzeuge.ladeAutomodelle(automodelleList);

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
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        accessFahrzeuge.erstelleAutomodell(automodelleList);
                        break;
                    case 2:
                        accessFahrzeuge.erstelleMotorradmodell(motorradmodelleList);
                        break;
                    case 3:
                        accessFahrzeuge.aktualisiereAutomodell(automodelleList);
                        break;
                    case 4:
                        accessFahrzeuge.aktualisiereMotorradmodell(motorradmodelleList);
                        break;
                    case 5:
                        accessFahrzeuge.loescheAutomodell(automodelleList);
                        break;
                    case 6:
                        accessFahrzeuge.loescheMotorradmodell(motorradmodelleList);
                        break;
                    case 7:
                        accessFahrzeuge.sucheAutomodell(automodelleList);
                        break;
                    case 8:
                        accessFahrzeuge.sucheMotorradmodell(motorradmodelleList);
                        break;
                    case 9:
                        exitProgramm = true;
                        accessFahrzeuge.speichereMotorradmodelle(motorradmodelleList);
                        accessFahrzeuge.speichereAutomodelle(automodelleList);

                        break;
                    default:
                        System.out.println("Ungültige Auswahl. Bitte geben Sie eine Zahl zwischen 1 und 9 ein.");
                }
            }
        }
    }
}