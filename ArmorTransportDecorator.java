public class ArmorTransportDecorator extends TransportDecorator {
    public ArmorTransportDecorator(Transport transport) {
        super(transport);
    }

    @Override
    public void startRoute() {
        super.startRoute();
        System.out.println("Upgrade: Heavy armor plating enabled for maximum security.");
    }
}