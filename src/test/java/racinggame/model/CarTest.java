package racinggame.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racinggame.common.exception.InvalidParamException;
import racinggame.common.response.ErrorCode;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CarTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private static final String successCarName = "Car";
    private static final String failCarName = "OverCar";
    private Car successCar;

    protected void setUp() {
        successCar = new Car(successCarName);
    }

    @BeforeEach
    void beforeEach() {
        setUp();
    }

    @Test
    void Car_전진1_스탑1_이동거리_1() {
        // when
        successCar.movingFront(MOVING_FORWARD);
        successCar.movingFront(STOP);

        // then
        assertThat(successCar.getDistance()).isEqualTo(1);
    }

    @Test
    void Car_스탑_이동거리_0() {
        // when
        successCar.movingFront(STOP);

        // then
        assertThat(successCar.getDistance()).isEqualTo(0);
    }

    @Test
    void Car_전진_이동거리_1() {
        // when
        successCar.movingFront(MOVING_FORWARD);

        // then
        assertThat(successCar.getDistance()).isEqualTo(1);
    }

    @Test
    void Car_이름_사이즈_오류() {
        assertThatExceptionOfType(InvalidParamException.class).isThrownBy(() -> {
            // when
            new Car(failCarName);
        })  // then
            .withMessage(ErrorCode.CAR_NAME_SIZE_OVER.getErrorMsg());
    }

    @Test
    void Car_생성() {
        // when
        Car newCar = new Car(successCarName);

        // then
        assertThat(newCar.getCarName()).isEqualTo(successCarName);
    }
}
