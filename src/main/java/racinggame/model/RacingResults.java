package racinggame.model;

import racinggame.common.response.CommonMessage;

import java.util.ArrayList;
import java.util.List;

public class RacingResults {
    private final List<RacingResult> racingResults = new ArrayList<>();
    private List<String> winners = new ArrayList<>();
    private int longestDistance = 0;

    public void add(RacingResult racingResult) {
        racingResults.add(racingResult);
    }

    public List<String> reports() {
        List<String> results = new ArrayList<>();
        for (int i = 0; i < racingResults.size(); i++) {
            RacingResult racingResult = racingResults.get(i);
            results.add(racingResult.report());

        }

        return results;
    }

    public String winnerReport() {
        for (int i = 0; i < racingResults.size(); i++) {
            mapLognestDistance(racingResults.get(i));
        }

        return String.join(CommonMessage.COMMA_SEPARATE.getMessage(), winners);
    }

    private void mapLognestDistance(RacingResult racingResult) {
        int distance = racingResult.getCarDistance();
        if (distance < longestDistance) {
            return;
        }

        if (distance > longestDistance) {
            resetWinners();
            longestDistance = distance;
        }
        winners.add(racingResult.getCarName());
    }

    private void resetWinners() {
        winners = new ArrayList<>();
    }

}
