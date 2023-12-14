import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {

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



        // Nur ein Test
        Automodell automodell = new Automodell("Skoda", "Octavia","Hellblau","Hybrid","Automatik-Getriebe",180);
        Motorradmodell motorradmodell = new Motorradmodell("Derbi", "Kenn Keine","Knallrot","Benzin","6-Gang-Manuellgetriebe",300);

    }
}
