public class Main {
    public static void main(String[] args) {
        System.out.println("--- 1. SINGLETON & STRATEGY TEST ---");
        CityController controller = CityController.getInstance();
        controller.manageInfrastructure("Checking city status...");
        
        // Testing dynamic behavior switching
        controller.performDailyCheck(); // Normal mode
        controller.setStrategy(new EmergencyModeStrategy());
        controller.performDailyCheck(); // Emergency mode

        System.out.println("\n--- 2. OBSERVER TEST ---");
        SecuritySensor sensor = new SecuritySensor();
        PublicSafetyAuthority police = new PublicSafetyAuthority();
        sensor.attach(police);
        sensor.detectThreat("Unauthorized server access");

        System.out.println("\n--- 3. ADAPTER TEST ---");
        CryptoService cryptoSystem = new CryptoService();
        DigitalBankingSystem adapter = new CryptoAdapter(cryptoSystem);
        adapter.processPayment(1000.0);

        System.out.println("\n--- 4. FACTORY & DECORATOR TEST ---");
        TransportFactory factory = new TransportFactory();
        
        // 1. Create a regular bus using Factory
        Transport myBus = factory.createTransport("BUS");
        
        if (myBus != null) {
            // 2. Wrap it with Wi-Fi using Decorator
            Transport wifiBus = new WifiTransportDecorator(myBus);
            
            // 3. Layer Armor ON TOP of the Wi-Fi bus (Double Decorator!)
            Transport armoredWifiBus = new ArmorTransportDecorator(wifiBus);
            
            System.out.println("Deploying a fully upgraded bus:");
            armoredWifiBus.startRoute();
        }

        // ВСТАВИЛИ СЮДА - ВНУТРЬ МЕТОДА MAIN!
        System.out.println("\n--- 5. COMMAND TEST ---");
        // Create the receiver
        StreetLight downtownLights = new StreetLight("Downtown Area");
        
        // Create the commands
        Command lightsOn = new TurnOnLightCommand(downtownLights);
        Command lightsOff = new TurnOffLightCommand(downtownLights);
        
        // Create the invoker (Remote control)
        CityAutomationRemote remote = new CityAutomationRemote();
        
        // Execute commands
        remote.setCommand(lightsOn);
        remote.pressButton(); // Simulating night time
        
        remote.setCommand(lightsOff);
        remote.pressButton(); // Simulating morning time
    }
}