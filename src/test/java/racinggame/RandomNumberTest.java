package racinggame;

import org.junit.jupiter.api.Test;
import racinggame.model.RandomNumber;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberTest {
    int MIN_RANDOM_NUMBER = 0;
    int MAX_RANDOM_NUMBER = 9;

    @Test
    void 랜덤_숫자_0_9_생성() {
        assertThat(RandomNumber.generator()).isBetween(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
    }
}
