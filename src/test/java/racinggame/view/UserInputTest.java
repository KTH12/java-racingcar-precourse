package racinggame.view;

import nextstep.test.NSTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UserInputTest extends NSTest {
    @BeforeEach
    void beforeEach() {
        setUp();
    }

    @ParameterizedTest
    @ValueSource(strings = {"Acar,Bcar,Ccar"})
    void 유저_콤마_입력_배열_체크(String input) {
        // given
        run(input);

        // then
        List<String> carNames = UserInput.readUserMessageToArray();

        // then
        assertThat(carNames)
            .containsExactly("Acar", "Bcar", "Ccar");
    }

    @ParameterizedTest
    @ValueSource(strings = {"hi"})
    void 유저_입력(String input) {
        // given
        run(input);

        // when
        String readValue = UserInput.readUserMessage();

        // then
        assertThat(readValue).isEqualTo(input);
    }

    @Override protected void runMain() {
    }
}
