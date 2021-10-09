package racinggame.model;

public class Car {
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

}
