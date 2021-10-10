package racinggame.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    public Cars(List<String> carNames) {
        mapCars(carNames);
    }

    public List<Car> getCars() {
        return cars;
    }

    private void mapCars(List<String> carNames) {
        for (String name : carNames) {
            cars.add(new Car(name));
        }
    }

    public RacingResults racing() {
        RacingResults racingResults = new RacingResults();
        for (Car car : cars) {
            RacingResult racingResult = play(car);
            racingResults.add(racingResult);
        }

        return racingResults;
    }

    private RacingResult play(Car car) {
        car.movingFront(RandomNumber.generator());
        return new RacingResult(car);
    }
}
