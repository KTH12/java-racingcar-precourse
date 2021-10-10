package racinggame.model;

import nextstep.test.NSTest;
import nextstep.utils.Console;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racinggame.view.UserOutput;

import java.util.Arrays;
import java.util.List;

class RacingResultsTest extends NSTest {
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

            // when
            Cars cars = createCars();
            racingResultPrintTest(cars);

            // then
            verify(CAR_NAME_A + " : -", CAR_NAME_B + " : -", "최종 우승자는 " + carNames + " 입니다.");
        }, MOVING_FORWARD, MOVING_FORWARD);
    }

    @Test
    void 전진_정지_단일_우승자_출력() {
        assertRandomTest(() -> {
            // given
            run(getCarNames(CAR_NAME_A, CAR_NAME_B));

            // when
            Cars cars = createCars();
            racingResultPrintTest(cars);

            // then
            verify(CAR_NAME_A + " : -", CAR_NAME_B + " : ", "최종 우승자는 " + CAR_NAME_A + " 입니다.");
        }, MOVING_FORWARD, STOP);
    }

    @Test
    void 레이싱_전진_출력() {
        assertRandomTest(() -> {
            // given
            run(getCarNames(CAR_NAME_A, CAR_NAME_B));

            // when
            Cars cars = createCars();
            racingResultPrintTest(cars);

            // then
            verify(CAR_NAME_A + " : -", CAR_NAME_B + " : ");
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

    private void racingResultPrintTest(Cars cars) {
        RacingResults racingResults = cars.racing();
        List<String> results = racingResults.reports();

        UserOutput.listLoopPrint(results);
        UserOutput.printWinner(racingResults.winnerReport());
    }

    @Override protected void runMain() {

    }
}
