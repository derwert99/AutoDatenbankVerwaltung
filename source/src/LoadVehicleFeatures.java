import java.util.ArrayList;
import java.util.Collections;

public class LoadVehicleFeatures {


    public static void LadeListen() {
        // Wird anhand des Users hinzugefügt
        ArrayList<String> farbenListe = new ArrayList<>();


        ArrayList<String> getriebeListe = new ArrayList<>();

        getriebeListe.add("Automatik-Getriebe");
        getriebeListe.add("6-Gang-Manuellgetriebe");
        getriebeListe.add("5-Gang-Manuellgetriebe");

        Collections.sort(getriebeListe);


        ArrayList<String> kraftstoffListe = new ArrayList<>();

        kraftstoffListe.add("Benzin");
        kraftstoffListe.add("Diesel");
        kraftstoffListe.add("Hybrid");
        kraftstoffListe.add("Elektro");
        kraftstoffListe.add("Erdgas");

        Collections.sort(kraftstoffListe);
    }
}
