public class Main {
    public static void main(String[] args) {
        System.out.println("--- 1. SINGLETON TEST ---");
        CityController controller = CityController.getInstance();
        controller.manageInfrastructure("Booting up smart city systems...");

        System.out.println("\n--- 2. OBSERVER TEST ---");
        SecuritySensor sensor = new SecuritySensor();
        PublicSafetyAuthority police = new PublicSafetyAuthority();
        
        sensor.attach(police);
        sensor.detectThreat("Unauthorized access to bank servers");

        System.out.println("\n--- 3. ADAPTER TEST ---");
        CryptoService externalCryptoSystem = new CryptoService();
        DigitalBankingSystem adapter = new CryptoAdapter(externalCryptoSystem);
        
        // Process a fiat payment of $1000, adapter handles crypto conversion implicitly
        adapter.processPayment(1000.0);

        System.out.println("\n--- 4. FACTORY TEST ---");
        TransportFactory factory = new TransportFactory();
        
        // Factory creates different objects without exposing instantiation logic
        Transport myBus = factory.createTransport("BUS");
        if (myBus != null) myBus.startRoute();

        Transport myMetro = factory.createTransport("METRO");
        if (myMetro != null) myMetro.startRoute();
    }
}