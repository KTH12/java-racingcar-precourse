package racinggame.model;

import nextstep.test.NSTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racinggame.common.exception.InvalidParamException;
import racinggame.common.response.ErrorCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CarsTest extends NSTest {

    @ParameterizedTest
    @CsvSource(value = {"OrverAcar,Bcar,Ccar"})
    void Cars_6자_이상_실패(String overSizeCar, String bCar, String cCar) {
        // given
        List<String> carNames = getCarNames(overSizeCar, bCar, cCar);

        assertThatExceptionOfType(InvalidParamException.class).isThrownBy(() -> {
            // when
            new Cars(carNames);

        })  // then
            .withMessage(ErrorCode.CAR_NAME_SIZE_OVER.getErrorMsg());
    }

    @ParameterizedTest
    @CsvSource(value = {"Acar,Bcar,Ccar"})
    void Cars_생성_테스트(String aCar, String bCar, String cCar) {
        // given
        List<String> carNames = getCarNames(aCar, bCar, cCar);

        // when
        Cars cars = new Cars(carNames);
        List<String> createCarsNameList = getCarsNameListOf(cars);

        //then
        assertThat(createCarsNameList).containsExactly(aCar, bCar, cCar);
    }

    private List<String> getCarNames(String overSizeCar, String bCar, String cCar) {
        return Arrays.asList(overSizeCar, bCar, cCar);
    }

    private List<String> getCarsNameListOf(Cars cars) {
        List<String> createCarsNameList = new ArrayList<>();
        for (Car car : cars.getCars()) {
            createCarsNameList.add(car.getCarName());
        }
        return createCarsNameList;
    }

    @Override protected void runMain() {
    }
}
