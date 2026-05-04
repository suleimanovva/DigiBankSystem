public class TransportFactory {
    
    public Transport createTransport(String type) {
        // Simple logic to create transport based on user input
        if (type.equalsIgnoreCase("BUS")) {
            return new BusTransport();
        } else if (type.equalsIgnoreCase("METRO")) {
            return new MetroTransport();
        }
        return null; // Return null if type is unknown
    }
}