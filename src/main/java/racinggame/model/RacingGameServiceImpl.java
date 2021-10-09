package racinggame.model;

import racinggame.common.exception.InvalidParamException;
import racinggame.common.response.CommonMessage;
import racinggame.view.UserInput;
import racinggame.view.UserOutput;

import java.util.List;

public class RacingGameServiceImpl implements RacingGameService {
    private TryCount tryCount;
    private Cars cars;
    private RacingResults racingResults;

    @Override public void init() {
        cars = createCarsProcess();
        tryCount = tryCountProcess();
        UserOutput.print("");
        UserOutput.print(CommonMessage.RESULT_MESSAGE.getMessage());
    }

    @Override public void racing() {
        racingResults = cars.racing();
        UserOutput.listLoopPrint(racingResults.reports());
        tryCount.incrementTryCount();
        UserOutput.print("");
    }

    @Override public boolean end() {
        if (tryCount.isMax()) {
            UserOutput.printWinner(racingResults.winnerReport());

            return true;
        }

        return false;
    }

    private Cars createCarsProcess() {
        List<String> carNames = carNamesProcess();

        try {
            return new Cars(carNames);
        } catch (InvalidParamException e) {
            UserOutput.print(e.getMessage());
            return createCarsProcess();
        }
    }

    private List<String> carNamesProcess() {
        try {
            UserOutput.print(CommonMessage.REQUIRE_CAR_NAMES.getMessage());
            List<String> carNames = UserInput.readUserMessageToArray();
            UserOutput.print(String.join(",", carNames));
            return carNames;
        } catch (InvalidParamException e) {
            UserOutput.print(e.getMessage());
            return carNamesProcess();
        }
    }

    private TryCount tryCountProcess() {
        try {
            return UserInput.readTryCount();
        } catch (InvalidParamException e) {
            UserOutput.print(e.getMessage());
            return tryCountProcess();
        }
    }

}
