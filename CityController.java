public class CityController {

    private static CityController instance;

    private CityController() {
        // init controller
        System.out.println("CityController initialized.");
    }

    public static CityController getInstance() {
        if (instance == null) {
            instance = new CityController();
        }
        return instance;
    }

    public void manageInfrastructure(String action) {
        System.out.println("Executing action: " + action);
    }
}