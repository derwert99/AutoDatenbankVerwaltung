public class Automodell extends Automarke {

    private String automodell;


    public Automodell(String automarke, String automodell, String farbe, String kraftstoff, String getriebe, int ps) {
        super(farbe, kraftstoff, getriebe, ps, automarke);
        this.automodell = automodell;
    }

    public String getAutomodell() {
        return automodell;
    }

    public void setAutomodell(String automodell) {
        this.automodell = automodell;
    }
}
