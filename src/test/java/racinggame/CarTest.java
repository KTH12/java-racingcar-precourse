package racinggame;

import org.junit.jupiter.api.Test;
import racinggame.common.exception.InvalidParamException;
import racinggame.model.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CarTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    String successCarName = "ACar";
    String failCarName = "SizeOverCar";

    @Test
    void Car_스탑_이동거리_0() {
        Car newCar = new Car(successCarName);
        newCar.movingFront(STOP);

        assertThat(newCar.getDistance()).isEqualTo(0);
    }

    @Test
    void Car_전진_이동거리_1() {
        Car newCar = new Car(successCarName);
        newCar.movingFront(MOVING_FORWARD);

        /*
          movingFront(MOVING_FORWARD)는 1씩 증가시킨다.
          그러므로, 결과는 이동거리 1이다.
         */
        assertThat(newCar.getDistance()).isEqualTo(1);
    }

    @Test
    void Car_이름_사이즈_오류() {
        assertThatExceptionOfType(InvalidParamException.class).isThrownBy(() -> {
            new Car(failCarName);
        });
    }

    @Test
    void Car_생성() {
        Car newCar = new Car(successCarName);

        assertThat(newCar.getCarName()).isEqualTo(successCarName);
    }
}
