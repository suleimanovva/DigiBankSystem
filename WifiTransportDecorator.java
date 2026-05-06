public class WifiTransportDecorator extends TransportDecorator {
    public WifiTransportDecorator(Transport transport) {
        super(transport);
    }

    @Override
    public void startRoute() {
        super.startRoute();
        System.out.println("Upgrade: High-speed Wi-Fi is now available for passengers.");
    }
}