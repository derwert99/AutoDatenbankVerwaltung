import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
        LoadVehicleFeatures.LadeListen();

        boolean exitProgramm = false;


        if (loggedIn) {




            while (!exitProgramm) {

                List<Motorradmodell> motorradmodellList = new ArrayList<>();
                AccessFahrzeuge.loadMotorradmodelle(motorradmodellList);

                List<Automodell> automodelleList = new ArrayList<>();
                AccessFahrzeuge.loadAutomodelle(automodelleList);

                List<GeparkteAutos> geparkteAutosList = new ArrayList<>();
                AccessFahrzeuge.loadGeparkteAutos(geparkteAutosList);


                List<GeparkteMotorrader> geparkteMotorraderList = new ArrayList<>();
                AccessFahrzeuge.loadGeparkteMotorrader(geparkteMotorraderList);

                System.out.println("Autmodell nach Nummertafel suchen -> AS"); //unfinished
                System.out.println("Motorradmodell nach Nummertafel suchen -> MS");  //unfinished
                System.out.println("Automodell löschen -> AL");         //unfinished !!!
                System.out.println("Motorradmodell löschen - > ML");  // unfinished!!!
                System.out.println("Automodell hinzufügen -> AG");
                System.out.println("Motorradmodell hinzufügen -> MG");
                System.out.println("Auto in Garage parken -> AP");
                System.out.println("Motorrad in Garage parken - MP");
                System.out.println("Auto aus Garage entfernen -> N");
                System.out.println("Motorrad aus Garage entfernen -> M");
                System.out.println("Exit -> E");

                String choice = scanner.nextLine().toUpperCase();
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
                    case "AG":
                        AccessFahrzeuge.automodellErstellen();
                        break;
                    case "MG":
                        AccessFahrzeuge.motorradmodellErstellen();
                        break;
                    case "AP":
                        AccessFahrzeuge.autoParken(automodelleList);
                        break;
                    case "MP":
                        AccessFahrzeuge.motorradParken(motorradmodellList);
                        break;
                    case "N":
                        AccessFahrzeuge.autoAusparken(geparkteAutosList);
                        break;
                    case "M":
                        AccessFahrzeuge.motorradAusparken(geparkteMotorraderList);
                        break;
                    case "E":
                        exitProgramm = true;
                        break;
                    default:
                        System.out.println("Ungültige Auswahl");
                        break;
                }
            }
        }
    }
}
