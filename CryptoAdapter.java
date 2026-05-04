public class CryptoAdapter implements DigitalBankingSystem {
    
    private CryptoService cryptoService;

    public CryptoAdapter(CryptoService cryptoService) {
        this.cryptoService = cryptoService;
    }

    @Override
    public void processPayment(double amount) {
        double convertedCrypto = amount * 0.00001; 
        String defaultWallet = "0xDIGIBANK_SMART_WALLET_999";
        
        System.out.println("Adapter: Converting $" + amount + " to crypto...");
        cryptoService.makeCryptoTransaction(defaultWallet, convertedCrypto);
    }
}