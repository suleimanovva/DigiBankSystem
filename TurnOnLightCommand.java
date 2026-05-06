public class TurnOnLightCommand implements Command {
    private StreetLight light;

    public TurnOnLightCommand(StreetLight light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}