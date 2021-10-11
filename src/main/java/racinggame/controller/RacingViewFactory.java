package racinggame.controller;

import racinggame.common.exception.InvalidParamException;
import racinggame.common.response.CommonMessage;
import racinggame.model.Cars;
import racinggame.model.TryCount;
import racinggame.view.UserInput;
import racinggame.view.UserOutput;

import java.util.List;

public class RacingViewFactory {

    public Cars createCarsToUser() {
        try {
            UserOutput.print(CommonMessage.REQUIRE_CAR_NAMES.getMessage());
            List<String> carNames = UserInput.readUserMessageToArray();
            printCarNames(carNames);
            return new Cars(carNames);
        } catch (InvalidParamException e) {
            UserOutput.print(e.getMessage());
            return createCarsToUser();
        }
    }

    public TryCount createTryCountToUser() {
        try {
            UserOutput.printTtyCount();
            String input = UserInput.readUserMessage();
            UserOutput.print(input);
            return new TryCount(input);
        } catch (InvalidParamException e) {
            UserOutput.print(e.getMessage());
            return createTryCountToUser();
        }
    }

    private void printCarNames(List<String> carNames) {
        UserOutput.print(String.join(",", carNames));
    }
}
