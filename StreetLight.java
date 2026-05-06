public class StreetLight {
    private String districtName;

    public StreetLight(String districtName) {
        this.districtName = districtName;
    }

    public void turnOn() {
        System.out.println("Infrastructure: Street lights in " + districtName + " turned ON.");
    }

    public void turnOff() {
        System.out.println("Infrastructure: Street lights in " + districtName + " turned OFF.");
    }
}