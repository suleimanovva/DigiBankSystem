import java.util.ArrayList;
import java.util.List;

public class SecuritySensor {
    private List<Observer> observers = new ArrayList<>();

    public void attach(Observer o) {
        observers.add(o);
    }

    public void notifyObservers(String message) {
        for (Observer o : observers) {
            o.update(message);
        }
    }

    public void detectThreat(String threatType) {
        System.out.println("Sensor: Threat detected -> " + threatType);
        notifyObservers("CRITICAL WARNING: " + threatType);
    }
}
