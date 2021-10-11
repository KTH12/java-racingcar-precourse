package racinggame.model;

public class Car {
    private static final String RACING_DISTANCE_BAR = "-";
    private static final String RACING_PROGRESS_FORMAT = "%s : %s";
    private final CarName carName;
    private final Engine engine;
    private int distance = 0;

    public Car(String carName) {
        this.carName = new CarName(carName);
        this.engine = new Engine();
    }

    public void movingFront(int power) {
        if (engine.isValidFront(power)) {
            incrementDistance();
        }
    }

    public int getDistance() {
        return distance;
    }

    public String getCarName() {
        return carName.getName();
    }

    private void incrementDistance() {
        distance++;
    }

    public String getProgress() {
        return String.format(RACING_PROGRESS_FORMAT, getCarName(), getDistanceProgressBar());
    }

    private String getDistanceProgressBar() {
        StringBuilder distanceProgressBar = new StringBuilder();
        for (int i = 0; i < distance; i++) {
            distanceProgressBar.append(RACING_DISTANCE_BAR);
        }
        return distanceProgressBar.toString();
    }
}
