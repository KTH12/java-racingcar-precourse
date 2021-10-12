package racinggame.model;

import racinggame.common.response.CarStatus;
import racinggame.common.response.CommonMessage;

import java.util.ArrayList;
import java.util.List;

public class RacingReport {
    private final Cars cars;
    private List<Car> winCars = new ArrayList<>();

    public RacingReport(Cars cars) {
        this.cars = cars;
    }

    public String getWinCarNamesFormatComma() {
        for (Car car : cars.getCars()) {
            winnerValidProcess(car);
        }

        return getWinCarNames();
    }

    private void winnerValidProcess(Car car) {
        if (car.isDistanceZero()) {
            return;
        }

        if (isAddWinner(car)) {
            winCars.add(car);
        }
    }

    private String getWinCarNames() {
        List<String> result = new ArrayList<>();
        for (Car car : winCars) {
            result.add(car.getCarName());
        }
        return String.join(CommonMessage.COMMA_SEPARATE.getMessage(), result);
    }

    private boolean isAddWinner(Car car) {
        if (winCars.isEmpty()) {
            return true;
        }

        CarStatus racingStatus = car.compareTo(getWinCarFirst());
        if (CarStatus.isDefeat(racingStatus)) {
            return false;
        }

        if (CarStatus.isNewRecord(racingStatus)) {
            winCars = new ArrayList<>();
        }
        return true;
    }

    private Car getWinCarFirst() {
        return winCars.get(0);
    }
}
