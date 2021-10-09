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

    @BeforeEach
    void beforeEach() {
        setUp();
    }

    @Test
    void 동시_우승자_출력() {
        assertRandomTest(() -> {
            Cars cars = createCars();

            racingResultTest(cars);
            verify("pobi : -", "woni : -", "최종 우승자는 pobi,woni 입니다.");
        }, MOVING_FORWARD, MOVING_FORWARD);
    }

    @Test
    void 우승자_출력() {
        assertRandomTest(() -> {
            Cars cars = createCars();

            racingResultTest(cars);
            verify("pobi : -", "woni : ", "최종 우승자는 pobi 입니다.");
        }, MOVING_FORWARD, STOP);
    }

    @Test
    void 레이싱_전진_출력() {
        assertRandomTest(() -> {
            Cars cars = createCars();

            racingResultTest(cars);
            System.out.println("완료");
            verify("pobi : -", "woni : ");
        }, MOVING_FORWARD, STOP);
    }

    private Cars createCars() {
        run("pobi,woni");
        String input = Console.readLine();
        List<String> carNames = Arrays.asList(input.split(","));

        return new Cars(carNames);
    }

    private void racingResultTest(Cars cars) {
        RacingResults racingResults = cars.racing();
        List<String> results = racingResults.reports();
        UserOutput.listLoopPrint(results);
        UserOutput.printWinner(racingResults.winnerReport());
    }

    @Override protected void runMain() {

    }
}