public class Motorradmodell extends Motorradmarke{

    private String motorradmodell;


    public Motorradmodell( String motorradmarke, String motorradmodell, String farbe, String kraftstoff, String getriebe, int ps) {
        super(farbe, kraftstoff, getriebe, ps, motorradmarke);
        this.motorradmodell = motorradmodell;
    }

    public String getMotorradmodell() {
        return motorradmodell;
    }

    public void setMotorradmodell(String motorradmodell) {
        this.motorradmodell = motorradmodell;
    }
}
