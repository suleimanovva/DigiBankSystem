public class EmergencyModeStrategy implements CityOperatingStrategy {
    @Override
    public void executeMode() {
        // Critical operations: minimize power, alert police, restrict access
        System.out.println("Strategy: EMERGENCY mode activated. Saving energy and alerting all authorities.");
    }
}