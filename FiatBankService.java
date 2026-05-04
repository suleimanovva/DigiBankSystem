public class FiatBankService implements DigitalBankingSystem {
    @Override
    public void processPayment(double amount) {
        System.out.println("FiatBank: Processing standard payment of $" + amount);
    }
}