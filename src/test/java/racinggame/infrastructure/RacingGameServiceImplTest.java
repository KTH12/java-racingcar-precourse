package racinggame.infrastructure;

import nextstep.test.NSTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racinggame.model.Cars;
import racinggame.model.RacingGameService;
import racinggame.model.RacingReport;
import racinggame.view.UserOutput;

import java.util.Arrays;
import java.util.List;

class RacingGameServiceImplTest extends NSTest {
    private static final String MULTI_WINNERS_FORMAT = "최종 우승자는 %s,%s 입니다.";
    private static final String WINNER_FORMAT = "최종 우승자는 %s 입니다.";
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private static final String CAR_NAME_A = "pobi";
    private static final String CAR_NAME_B = "woni";

    RacingGameService racingGameService;

    @BeforeEach
    void beforeEach() {
        setUp();
        racingGameService = new RacingGameServiceImpl();
    }

    @Test
    void 다중_우승자() {
        assertRandomTest(() -> {
            // given
            List<String> carNames = Arrays.asList(CAR_NAME_A, CAR_NAME_B);

            // when
            gameRun(carNames, 1);

            // when
            verify(CAR_NAME_A + " : -", CAR_NAME_B + " : -",
                String.format(MULTI_WINNERS_FORMAT, CAR_NAME_A, CAR_NAME_B));
        }, MOVING_FORWARD, MOVING_FORWARD);
    }

    @Test
    void 최종_우승자() {
        assertRandomTest(() -> {
            // given
            List<String> carNames = Arrays.asList(CAR_NAME_A, CAR_NAME_B);

            // when
            gameRun(carNames, 1);

            // then
            verify(CAR_NAME_A + " : -", CAR_NAME_B + " : ", String.format(WINNER_FORMAT, CAR_NAME_A));
        }, MOVING_FORWARD, STOP);
    }

    private void gameRun(List<String> carNames, int tryCount) {
        // Cars 세팅
        racingGameService.init(new Cars(carNames));
        racePlay(tryCount);

        // 최종 승자 출력진행
        RacingReport racingReport = racingGameService.end();
        UserOutput.printWinner(racingReport.getWinCarNames());
    }

    private void racePlay(int tryCount) {
        while (isEnd(tryCount)) {
            // 레이싱 진행
            List<String> roundReport = racingGameService.racing();
            // 레이싱 자동차 이름 + 전진 거리 출력
            UserOutput.listLoopPrint(roundReport);
            tryCount--;
        }
    }

    private boolean isEnd(int tryCount) {
        return tryCount > 0;
    }

    @Override protected void runMain() {
    }
}
