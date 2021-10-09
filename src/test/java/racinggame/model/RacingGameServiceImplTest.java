package racinggame.model;

import nextstep.test.NSTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameServiceImplTest extends NSTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    RacingGameService racingGameService = new RacingGameServiceImpl();

    @BeforeEach
    void beforeEach() {
        setUp();
    }

    @Test
    void 게임_종료() {
        assertRandomTest(() -> {
            run("pobi,woni", "1");
            assertThat(racingGameService.end()).isEqualTo(true);
        }, MOVING_FORWARD, MOVING_FORWARD);
    }

    @Test
    void 다중_우승자() {
        assertRandomTest(() -> {
            run("pobi,woni", "1");
            verify("pobi : -", "woni : ", "최종 우승자는 pobi,woni 입니다.");
        }, MOVING_FORWARD, MOVING_FORWARD);
    }

    @Test
    void 최종_우승자() {
        assertRandomTest(() -> {
            run("pobi,woni", "1");
            verify("pobi : -", "woni : ", "최종 우승자는 pobi 입니다.");
        }, MOVING_FORWARD, STOP);
    }

    @Override protected void runMain() {
        racingGameService.init();
        do {
            racingGameService.racing();
        } while (!racingGameService.end());
    }
}