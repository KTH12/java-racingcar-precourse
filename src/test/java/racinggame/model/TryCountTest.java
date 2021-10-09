package racinggame.model;

import nextstep.test.NSTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racinggame.common.exception.InvalidParamException;
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
        TryCount tryCount = new TryCount(count);
        tryCount.incrementTryCount();
        assertThat(tryCount.isMax()).isEqualTo(true);
    }

    @ParameterizedTest
    @CsvSource(value = {"3, 1"})
    void 시도_회수_증가(String count, int resultCount) {
        TryCount tryCount = new TryCount(count);
        tryCount.incrementTryCount();
        assertThat(tryCount.getTryCount()).isEqualTo(resultCount);
    }

    @ParameterizedTest
    @ValueSource(strings = {"A"})
    void 시도_회수_문자_입력_실패(String input) {
        assertThatExceptionOfType(InvalidParamException.class).isThrownBy(() -> {
            run(input);
            UserInput.readTryCount();
            verify("시도할 회수는 몇회인가요?", "1");
        }).withMessage(ErrorCode.ONLY_NUMBER.getErrorMsg());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1"})
    void 시도_회수_입력_받기(String input) {
        assertSimpleTest(() -> {
            run(input);
            UserInput.readTryCount();
            verify("시도할 회수는 몇회인가요?", "1");
        });
    }

    @Override protected void runMain() {

    }
}