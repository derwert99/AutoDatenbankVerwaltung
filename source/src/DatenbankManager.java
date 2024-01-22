import java.util.ArrayList;
import java.util.List;

public class DatenbankManager {

    private AccessFahrzeuge accessFahrzeuge;
    private List<Motorradmodell> motorradmodelleList;
    private List<Automodell> automodelleList;

    public DatenbankManager() {
        this.accessFahrzeuge = new AccessFahrzeuge();
        this.motorradmodelleList = new ArrayList<>();
        this.automodelleList = new ArrayList<>();
    }

    public void ladeDatenbank() {
        motorradmodelleList = accessFahrzeuge.ladeMotorradmodelle();
        automodelleList = accessFahrzeuge.ladeAutomodelle();
    }

    public void speichereDatenbank() {
        accessFahrzeuge.speichereMotorradmodelle(motorradmodelleList);
        accessFahrzeuge.speichereAutomodelle(automodelleList);
    }

    public AccessFahrzeuge getAccessFahrzeuge() {
        return accessFahrzeuge;
    }

    public List<Motorradmodell> getMotorradmodelleList() {
        return motorradmodelleList;
    }

    public List<Automodell> getAutomodelleList() {
        return automodelleList;
    }
}
