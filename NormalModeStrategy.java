public class NormalModeStrategy implements CityOperatingStrategy {
    @Override
    public void executeMode() {
        // Routine city operations: lights on, standard traffic, normal power
        System.out.println("Strategy: City is operating in NORMAL mode. All systems are green.");
    }
}