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

        System.out.println("\n--- 6. TEMPLATE METHOD TEST ---");
        DailyRoutineTemplate lightingRoutine = new LightingScheduleRoutine();
        DailyRoutineTemplate securityRoutine = new SecurityCheckRoutine();

        System.out.println("Executing Lighting Routine:");
        lightingRoutine.executeRoutine();

        System.out.println("Executing Security Routine:");
        securityRoutine.executeRoutine();

        // БОНУСНОЕ ЗАДАНИЕ ВСТАВЛЕНО СЮДА — ВНУТРЬ MAIN!
        System.out.println("\n--- 7. BONUS TASK (10 POINTS): TXT EXPORT & OBSERVER ---");
        // 1. Create the monitor and email service
        FileExportMonitor fileMonitor = new FileExportMonitor();
        EmailNotificationService emailAlert = new EmailNotificationService("nigaraazamatovna@gmail.com");
        
        // 2. Attach observer to monitor
        fileMonitor.addObserver(emailAlert);
        
        // 3. Register a few users
        fileMonitor.registerUser(new User("John Doe"));
        fileMonitor.registerUser(new User("Alice Smith"));
        fileMonitor.registerUser(new User("Bob Crypto"));
        
        // 4. Trigger the export (This will create the txt file and trigger the email)
        fileMonitor.exportUserData();
    }
}