public class GeparkteMotorrader {

    private String nummertafel;

    private String motorradmodell;


    public GeparkteMotorrader(String nummertafel, String motorradmodell) {
        this.nummertafel = nummertafel;
        this.motorradmodell = motorradmodell;
    }

    public String getNummertafel() {
        return nummertafel;
    }

    public String getMotorradmodell() {
        return motorradmodell;
    }

    public void setNummertafel(String nummertafel) {
        this.nummertafel = nummertafel;
    }

    public void setMotorradmodell(String motorradmodell) {
        this.motorradmodell = motorradmodell;
    }
}
