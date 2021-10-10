package racinggame.infrastructure;

import nextstep.test.NSTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racinggame.model.RacingGameService;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameServiceImplTest extends NSTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private static final String CAR_NAME_A = "pobi";
    private static final String CAR_NAME_B = "woni";
    private static final String TRY_COUNT = "1";

    RacingGameService racingGameService;

    @BeforeEach
    void beforeEach() {
        setUp();
        racingGameService = new RacingGameServiceImpl();
    }

    @Test
    void 게임_종료() {
        assertRandomTest(() -> {
            // given
            String carNames = getCarNames(CAR_NAME_A, CAR_NAME_B);
            run(carNames, TRY_COUNT);

            // when
            gameRun();
            boolean isEnd = racingGameService.end();

            // then
            assertThat(isEnd).isEqualTo(true);
        }, MOVING_FORWARD, MOVING_FORWARD);
    }

    @Test
    void 다중_우승자() {
        assertRandomTest(() -> {
            // given
            String carNames = getCarNames(CAR_NAME_A, CAR_NAME_B);
            run(carNames, TRY_COUNT);

            // when
            // MOVING_FORWARD, MOVING_FORWARD (전진, 전진)
            gameRun();

            // when
            verify(CAR_NAME_A + " : -", CAR_NAME_B + " : -", "최종 우승자는 " + carNames + " 입니다.");
        }, MOVING_FORWARD, MOVING_FORWARD);
    }

    @Test
    void 최종_우승자() {
        assertRandomTest(() -> {
            // given
            String carNames = getCarNames(CAR_NAME_A, CAR_NAME_B);
            run(carNames, TRY_COUNT);

            // when
            // MOVING_FORWARD, STOP (전진, 정지)
            gameRun();

            // then
            verify(CAR_NAME_A + " : -", CAR_NAME_B + " : ", "최종 우승자는 " + CAR_NAME_A + " 입니다.");
        }, MOVING_FORWARD, STOP);
    }

    private String getCarNames(String... arg) {
        return String.join(",", arg);
    }

    private void gameRun() {
        racingGameService.init();
        do {
            racingGameService.racing();
        } while (!racingGameService.end());
    }

    @Override protected void runMain() {
    }
}
