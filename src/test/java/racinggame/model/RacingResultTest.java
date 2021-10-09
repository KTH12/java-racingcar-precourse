package racinggame.model;

import nextstep.test.NSTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racinggame.view.UserOutput;

class RacingResultTest extends NSTest {
    private static final int MOVING_FORWARD = 4;
    String carName = "ACar";

    @BeforeEach
    void beforeEach() {
        setUp();
    }

    @Test
    void 자동차_이름_이동거리_출력() {
        Car car = new Car(carName);
        car.movingFront(MOVING_FORWARD);

        RacingResult racingResult = new RacingResult(car);
        UserOutput.print(racingResult.report());
        System.out.println("완료");
        verify(carName + " : -");
    }

    @Override protected void runMain() {

    }
}