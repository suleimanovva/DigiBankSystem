public class TurnOffLightCommand implements Command {
    private StreetLight light;

    public TurnOffLightCommand(StreetLight light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}