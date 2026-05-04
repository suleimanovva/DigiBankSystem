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
        
      
        adapter.processPayment(1000.0);
    }
}