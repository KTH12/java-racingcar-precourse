package racinggame.model;

public class RacingResult {
    private static final String RACING_DISTANCE_BAR = "-";
    private static final String RACING_REPORT_FORMAT = "%s : %s";
    private final Car car;

    public RacingResult(Car car) {
        this.car = car;
    }

    public String report() {
        return String.format(RACING_REPORT_FORMAT, getCarName(), getDistance());
    }

    public String getCarName() {
        return car.getCarName();
    }

    public String getDistance() {
        StringBuilder distanceBar = new StringBuilder();
        for (int i = 0; i < car.getDistance(); i++) {
            distanceBar.append(RACING_DISTANCE_BAR);
        }
        return distanceBar.toString();
    }

    public int getCarDistance() {
        return car.getDistance();
    }
}
