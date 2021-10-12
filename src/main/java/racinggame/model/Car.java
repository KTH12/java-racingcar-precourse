package racinggame.model;

import racinggame.common.response.CarStatus;
import racinggame.common.response.CommonMessage;

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

    public CarStatus compareTo(Car car) {
        if (this.isWin(car.getDistance())) {
            return CarStatus.NEW_RECORD;
        }

        if (this.isTie(car.getDistance())) {
            return CarStatus.TIE_RECORD;
        }

        return CarStatus.DEFEAT;
    }

    public String getProgress() {
        return String.format(CommonMessage.RACING_PROGRESS_FORMAT.getMessage(), getCarName(), getDistanceProgressBar());
    }

    private String getDistanceProgressBar() {
        StringBuilder distanceProgressBar = new StringBuilder();
        for (int i = 0; i < distance; i++) {
            distanceProgressBar.append(CommonMessage.RACING_DISTANCE_BAR.getMessage());
        }
        return distanceProgressBar.toString();
    }

    public boolean isDistanceZero() {
        return distance == 0;
    }

    public String getCarName() {
        return carName.getName();
    }

    public int getDistance() {
        return distance;
    }

    private void incrementDistance() {
        distance++;
    }

    private boolean isTie(int distance) {
        return this.distance == distance;
    }

    private boolean isWin(int distance) {
        return this.distance > distance;
    }

}
