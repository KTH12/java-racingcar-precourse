package racinggame.model;

import nextstep.test.NSTest;
import nextstep.utils.Console;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racinggame.view.UserOutput;

import java.util.Arrays;
import java.util.List;

class RacingReportTest extends NSTest {
    private static final String WINNER_FORMAT = "최종 우승자는 %s 입니다.";
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private static final String CAR_NAME_A = "pobi";
    private static final String CAR_NAME_B = "woni";

    @BeforeEach
    void beforeEach() {
        setUp();
    }

    @Test
    void 전진_전진_동시_우승자_출력() {
        assertRandomTest(() -> {
            // given
            String carNames = getCarNames(CAR_NAME_A, CAR_NAME_B);
            run(carNames);

            // when`
            Cars cars = createCars();
            racingResultPrint(cars);

            // then
            verify(String.format(WINNER_FORMAT, carNames));
        }, MOVING_FORWARD, MOVING_FORWARD);
    }

    @Test
    void 전진_정지_단일_우승자_출력() {
        assertRandomTest(() -> {
            // given
            run(getCarNames(CAR_NAME_A, CAR_NAME_B));

            // when
            Cars cars = createCars();
            racingResultPrint(cars);

            // then
            verify(String.format(WINNER_FORMAT, CAR_NAME_A));
        }, MOVING_FORWARD, STOP);
    }

    private Cars createCars() {
        String input = Console.readLine();
        List<String> carNames = Arrays.asList(input.split(","));

        return new Cars(carNames);
    }

    private String getCarNames(String... arg) {
        return String.join(",", arg);
    }

    private void racingResultPrint(Cars cars) {
        List<String> report = cars.racing();

        UserOutput.listLoopPrint(report);
        UserOutput.printWinner(cars.report().getWinCarNames());
    }

    @Override protected void runMain() {

    }
}
