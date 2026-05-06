public class CityController {
    private static CityController instance;
    private CityOperatingStrategy currentStrategy; 

    private CityController() {
        // Initialize with Normal mode as the default
        this.currentStrategy = new NormalModeStrategy();
    }

    public static CityController getInstance() {
        if (instance == null) {
            instance = new CityController();
        }
        return instance;
    }

    // This allows us to change behavior at runtime (Strategy Pattern)
    public void setStrategy(CityOperatingStrategy strategy) {
        this.currentStrategy = strategy;
    }

    // Execute logic based on whatever strategy is currently active
    public void performDailyCheck() {
        if (currentStrategy != null) {
            currentStrategy.executeMode();
        }
    }

    public void manageInfrastructure(String action) {
        System.out.println("CityController active.");
        System.out.println("Executing action: " + action);
    }
}