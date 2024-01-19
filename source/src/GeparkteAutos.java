public class GeparkteAutos {

    private String nummertafel;

    private String automodell;

    public GeparkteAutos(String nummertafel, String automodell) {
        this.nummertafel = nummertafel;
        this.automodell = automodell;
    }

    public String getNummertafel() {
        return nummertafel;
    }

    public String getAutomodell() {
        return automodell;
    }

    public void setNummertafel(String nummertafel) {
        this.nummertafel = nummertafel;
    }

    public void setAutomodell(String automodell) {
        this.automodell = automodell;
    }
}
