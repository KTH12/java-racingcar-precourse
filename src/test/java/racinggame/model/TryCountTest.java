package racinggame.model;

import nextstep.test.NSTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racinggame.common.exception.InvalidParamException;
import racinggame.common.response.CommonMessage;
import racinggame.common.response.ErrorCode;
import racinggame.view.UserInput;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class TryCountTest extends NSTest {
    @BeforeEach
    void beforeEach() {
        setUp();
    }

    @ParameterizedTest
    @CsvSource(value = {"1"})
    void 시도_회수_도달(String count) {
        // given
        TryCount tryCount = new TryCount(count);

        // when
        tryCount.incrementTryCount();

        // then
        assertThat(tryCount.isMax()).isEqualTo(true);
    }

    @ParameterizedTest
    @CsvSource(value = {"3, 1"})
    void 시도_회수_증가(String count, int resultCount) {
        // given
        TryCount tryCount = new TryCount(count);

        // when
        tryCount.incrementTryCount();

        // then
        assertThat(tryCount.getTryCount()).isEqualTo(resultCount);
    }

    @ParameterizedTest
    @ValueSource(strings = {"A"})
    void 시도_회수_문자_입력_실패(String input) {
        assertThatExceptionOfType(InvalidParamException.class).isThrownBy(() -> {
            // given
            run(input);

            // when
            UserInput.readTryCount();

        }) // then
            .withMessage(ErrorCode.ONLY_NUMBER.getErrorMsg());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1"})
    void 시도_회수_입력_받기(String input) {
        assertSimpleTest(() -> {
            // given
            run(input);

            // when
            UserInput.readTryCount();

            // then
            verify(CommonMessage.REQUIRE_TRY_COUNT.getMessage(), "1");
        });
    }

    @Override protected void runMain() {
    }
}
