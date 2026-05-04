public class PublicSafetyAuthority implements Observer {
    @Override
    public void update(String message) {
        System.out.println("Public Safety Dept received alert: " + message);
        System.out.println("Dispatching units...");
    }
}
