package racinggame.view;

import nextstep.test.NSTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racinggame.common.exception.InvalidParamException;
import racinggame.common.response.ErrorCode;
import racinggame.model.Cars;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class UserInputTest extends NSTest {
    @BeforeEach
    void beforeEach() {
        setUp();
    }

    @ParameterizedTest
    @ValueSource(strings = {"OrverAcar,Bcar,Ccar"})
    void 콤마_입력_자동차_생성_6자_실패(String input) {
        assertThatExceptionOfType(InvalidParamException.class).isThrownBy(() -> {
            run(input);
            List<String> carNames = UserInput.readUserMessageToArray();

            new Cars(carNames);
        }).withMessage(ErrorCode.CAR_NAME_SIZE_OVER.getErrorMsg());

    }

    @ParameterizedTest
    @ValueSource(strings = {"Acar,Bcar,Ccar"})
    void 콤마_입력_자동차_생성(String input) {
        run(input);
        List<String> carNames = UserInput.readUserMessageToArray();

        new Cars(carNames);
    }

    @Override protected void runMain() {
    }
}
