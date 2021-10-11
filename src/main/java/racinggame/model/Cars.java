package racinggame.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    public Cars(List<String> carNames) {
        mapCars(carNames);
    }

    public List<String> racing() {
        List<String> roundProgressReports = new ArrayList<>();
        for (Car car : cars) {
            play(car);
            roundProgressReports.add(car.getProgress());
        }

        return roundProgressReports;
    }

    public RacingReport report() {
        return new RacingReport(cars);
    }

    public List<Car> getCars() {
        return cars;
    }

    private void play(Car car) {
        car.movingFront(RandomNumber.generator());
    }

    private void mapCars(List<String> carNames) {
        for (String name : carNames) {
            cars.add(new Car(name));
        }
    }
}
