public abstract class TransportDecorator implements Transport {
    protected Transport decoratedTransport;

    public TransportDecorator(Transport transport) {
        this.decoratedTransport = transport;
    }

    @Override
    public void startRoute() {
        decoratedTransport.startRoute();
    }
}