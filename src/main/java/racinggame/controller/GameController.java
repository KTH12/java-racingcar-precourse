package racinggame.controller;

import racinggame.infrastructure.RacingGameServiceImpl;
import racinggame.model.RacingGameService;

public class GameController {
    RacingGameService racingGameService = new RacingGameServiceImpl();

    public void run() {
        racingGameService.init();
        do {
            racingGameService.racing();
        } while (!racingGameService.end());
    }
}
