package racinggame.model;

import racinggame.common.response.CommonMessage;

import java.util.ArrayList;
import java.util.List;

public class RacingReport {
    private final List<Car> cars;
    private List<String> winCarNames = new ArrayList<>();
    private int longestDistance = 0;

    public RacingReport(List<Car> cars) {
        this.cars = cars;
    }

    public String getWinCarNames() {
        for (Car car : cars) {
            winnerCheck(car);
        }

        return String.join(CommonMessage.COMMA_SEPARATE.getMessage(), winCarNames);
    }

    private void winnerCheck(Car car) {
        if (isWin(car)) {
            winCarNames.add(car.getCarName());
        }
    }

    private boolean isWin(Car car) {
        int distance = car.getDistance();
        if (isNewOrTieRecord(distance)) {
            resetWin(distance);
            return true;
        }

        return false;
    }

    private void resetWin(int distance) {
        if (isNewRecord(distance)) {
            winCarNames = new ArrayList<>();
            longestDistance = distance;
        }
    }

    private boolean isNewOrTieRecord(int distance) {
        if (isZero(distance)) {
            return false;
        }
        return distance >= longestDistance;
    }

    private boolean isZero(int distance) {
        return distance == 0;
    }

    private boolean isNewRecord(int distance) {
        return distance > longestDistance;
    }

}
