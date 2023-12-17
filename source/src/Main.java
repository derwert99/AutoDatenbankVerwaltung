import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

       LoadVehicleFeatures.LadeListen();


        //////////////////////////////////////////////////////////////////////////////
        // provisorischer Ablauf


        Scanner scanner = new Scanner(System.in);


        System.out.println("Bitte geben Sie Ihren Benutzernamen ein:");
        String username = scanner.nextLine();
        System.out.println("Bitte geben Sie Ihr Passwort ein:");
        String password = scanner.nextLine();


        boolean exitProgramm = false;
        if (!AccessCredentials.checkCredentials(username, password)) {
            System.out.println("Benutzername oder Passwort falsch. Zugriff verweigert.");
        } else {
            System.out.println("Autmoodell nach Nummertafel suchen -> AS");
            System.out.println("Motorradmodell nach Nummertafel suchen -> MS");
            System.out.println("Automodell löschen -> AL");
            System.out.println("Motorradmodell löschen - > ML");
            System.out.println("Exit -> E");

            String choice = scanner.nextLine();
            String nummertafel = "";
            switch (choice) {
                case "AS":
                    System.out.print("Geben Sie die Nummertafel: ");
                   nummertafel = scanner.nextLine();
                    AccessFahrzeuge.accessAutomodell(nummertafel);
                    break;
                case "MS":
                    System.out.print("Geben Sie die Nummertafel: ");
                   nummertafel = scanner.nextLine();
                    AccessFahrzeuge.accessMotorradmodell(nummertafel);
                    break;
                case "AL":
                    System.out.print("Geben Sie die Nummertafel: ");
                    nummertafel = scanner.nextLine();
                    AccessFahrzeuge.deleteAutomodell(nummertafel);
                    break;
                case "ML":
                    System.out.print("Geben Sie die Nummertafel: ");
                    nummertafel = scanner.nextLine();
                    AccessFahrzeuge.deleteMotorradmodell(nummertafel);
                    break;
                case "E":
                    exitProgramm = true;
                    break;
                default:
                    System.out.println("Ungültige Auswahl");
                    break;
            }
        }


        // Nur ein Test
        Automodell automodell = new Automodell("Skoda", "Octavia", "Hellblau", "Hybrid", "Automatik-Getriebe", 180);
        Motorradmodell motorradmodell = new Motorradmodell("Derbi", "Kenn Keine", "Knallrot", "Benzin", "6-Gang-Manuellgetriebe", 300);

    }
}
