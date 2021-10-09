package racinggame.model;

import nextstep.test.NSTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racinggame.common.exception.InvalidParamException;
import racinggame.common.response.ErrorCode;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CarsTest extends NSTest {

    @ParameterizedTest
    @ValueSource(strings = {"OrverAcar,Bcar,Ccar"})
    void Cars_6자_실패(String inputCarNames) {
        assertThatExceptionOfType(InvalidParamException.class).isThrownBy(() -> {
            List<String> carNames = getNameList(inputCarNames);

            new Cars(carNames);
        }).withMessage(ErrorCode.CAR_NAME_SIZE_OVER.getErrorMsg());
    }

    @ParameterizedTest
    @ValueSource(strings = {"Acar,Bcar,Ccar"})
    void 여러대_자동차_생성(String inputCarNames) {
        List<String> carNames = getNameList(inputCarNames);

        Cars cars = new Cars(carNames);
        List<Car> carList = cars.getCars();
        for (int i = 0; i < carList.size(); i++) {
            assertThat(carList.get(i).getCarName()).isEqualTo(carNames.get(i));
        }
    }

    private List<String> getNameList(String inputCarNames) {
        return Arrays.asList(inputCarNames.split(","));
    }

    @Override protected void runMain() {
    }
}
