package racinggame.controller;

import nextstep.test.NSTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racinggame.model.Car;
import racinggame.model.Cars;
import racinggame.model.TryCount;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingViewFactoryTest extends NSTest {
    private static final String ERROR_MESSAGE = "[ERROR]";
    private final RacingViewFactory racingViewFactory = new RacingViewFactory();

    @BeforeEach
    void beforeEach() {
        setUp();
    }

    @Test
    void 사용자_자동차_생성() {
        assertSimpleTest(() -> {
            // given
            run("pobi,foo");

            // when
            List<String> carNames = carsNameOfUser();

            // then
            System.out.println(carNames);
            assertThat(carNames).containsExactly("pobi", "foo");
        });
    }

    @Test
    void 사용자_시도_회수_생성() {
        assertSimpleTest(() -> {
            int userCount = 1;
            // given
            run(String.valueOf(userCount));

            // when
            TryCount tryCount = racingViewFactory.createTryCountToUser();

            // then
            assertThat(tryCount.getCount()).isEqualTo(userCount);
        });
    }

    @Test
    void 사용자_시도_회수_생성_실패_성공() {
        assertSimpleTest(() -> {
            // given
            run("a", "1");

            // when
            racingViewFactory.createTryCountToUser();

            // then
            verify(ERROR_MESSAGE);
        });
    }

    private List<String> carsNameOfUser() {
        Cars cars = racingViewFactory.createCarsToUser();
        List<String> carNames = new ArrayList<>();
        for (Car car : cars.getCars()) {
            carNames.add(car.getCarName());
        }
        return carNames;
    }

    @Override protected void runMain() {
    }
}
