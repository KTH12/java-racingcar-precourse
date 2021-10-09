package racinggame.controller;

import racinggame.model.RacingGameService;
import racinggame.model.RacingGameServiceImpl;

public class GameController {
    RacingGameService racingGameService = new RacingGameServiceImpl();

    public void run() {
        racingGameService.init();
        do {
            racingGameService.racing();
        } while (!racingGameService.end());
    }
}
