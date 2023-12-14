public class Motorradmarke extends Motorrad {

    private String motorradmarke;

    public Motorradmarke(String farbe, String kraftstoff, String getriebe, int ps, String motorradmarke) {
        super(farbe, kraftstoff, getriebe, ps);
        this.motorradmarke = motorradmarke;
    }

    public String getMotorradmarke() {
        return motorradmarke;
    }

    public void setMotorradmarke(String motorradmarke) {
        this.motorradmarke = motorradmarke;
    }
}
