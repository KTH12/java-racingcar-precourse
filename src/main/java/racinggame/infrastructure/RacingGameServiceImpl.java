package racinggame.infrastructure;

import racinggame.model.Cars;
import racinggame.model.RacingGameService;
import racinggame.model.RacingReport;

import java.util.List;

public class RacingGameServiceImpl implements RacingGameService {
    private Cars cars;

    @Override public void init(Cars cars) {
        this.cars = cars;
    }

    @Override public List<String> racing() {
        return cars.racing();
    }

    @Override public RacingReport end() {
        return cars.report();
    }

}
