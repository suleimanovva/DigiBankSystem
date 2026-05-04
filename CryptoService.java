public class CryptoService {
    public void makeCryptoTransaction(String walletAddress, double cryptoAmount) {
        System.out.println("CryptoService: Transferring " + cryptoAmount + " BTC to wallet [" + walletAddress + "]");
    }
}
