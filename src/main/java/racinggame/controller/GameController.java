package racinggame.controller;

import racinggame.common.response.CommonMessage;
import racinggame.infrastructure.RacingGameServiceImpl;
import racinggame.model.Cars;
import racinggame.model.RacingGameService;
import racinggame.model.RacingReport;
import racinggame.model.TryCount;
import racinggame.view.UserOutput;

import java.util.List;

public class GameController {
    RacingGameService racingGameService = new RacingGameServiceImpl();
    RacingViewFactory facingViewFactory = new RacingViewFactory();
    TryCount tryCount;

    public void run() {
        racingGameInit();
        do {
            racing();
            roundProcess();
        } while (!isEnd());
    }

    private void racingGameInit() {
        Cars cars = facingViewFactory.createCarsToUser();
        tryCount = facingViewFactory.createTryCountToUser();

        racingGameService.init(cars);
        UserOutput.print(CommonMessage.RESULT_MESSAGE.getMessage());
    }

    private void racing() {
        List<String> roundProgressReports = racingGameService.racing();

        roundRacingPrint(roundProgressReports);
    }

    private void roundProcess() {
        tryCount.incrementTryCount();

        if (isEnd()) {
            racingWinnerPrint();
        }
    }

    private void racingWinnerPrint() {
        RacingReport racingReport = racingGameService.end();

        String winnerCarNames = racingReport.getWinCarNames();
        if (winnerCarNames.isEmpty()) {
            UserOutput.print(CommonMessage.NOTHING_WINNER.getMessage());
            return;
        }
        UserOutput.printWinner(winnerCarNames);
    }

    private void roundRacingPrint(List<String> roundProgressReports) {
        UserOutput.listLoopPrint(roundProgressReports);
    }

    private boolean isEnd() {
        return tryCount.isMax();
    }

}
