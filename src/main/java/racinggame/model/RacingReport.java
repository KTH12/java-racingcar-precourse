package racinggame.model;

import racinggame.common.response.CommonMessage;

import java.util.ArrayList;
import java.util.List;

public class RacingReport {
    private final List<Car> cars;
    private List<String> winCarNames;
    private int longestDistance = 0;

    public RacingReport(List<Car> cars) {
        this.cars = cars;
        resetWin();
    }

    public String getWinCarNames() {
        for (Car car : cars) {
            if (isWin(car)) {
                winCarNames.add(car.getCarName());
            }
        }

        return String.join(CommonMessage.COMMA_SEPARATE.getMessage(), winCarNames);
    }

    private boolean isWin(Car car) {
        int distance = car.getDistance();
        if (distance < longestDistance) {
            return false;
        }

        if (distance > longestDistance) {
            resetWin();
            longestDistance = distance;
        }
        return true;
    }

    private void resetWin() {
        winCarNames = new ArrayList<>();
    }
}
