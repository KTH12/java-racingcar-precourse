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
        for (RacingResult racingResult : racingResults) {
            results.add(racingResult.report());
        }

        return results;
    }

    public String winnerReport() {
        for (RacingResult racingResult : racingResults) {
            mapLongestDistance(racingResult);
        }

        return String.join(CommonMessage.COMMA_SEPARATE.getMessage(), winners);
    }

    private void mapLongestDistance(RacingResult racingResult) {
        int distance = racingResult.getCarDistance();
        if (distance < longestDistance) {
            return;
        }

        if (distance > longestDistance) {
            newWinnerSetting(distance);
        }
        winners.add(racingResult.getCarName());
    }

    private void newWinnerSetting(int distance) {
        resetWinners();
        longestDistance = distance;
    }

    private void resetWinners() {
        winners = new ArrayList<>();
    }

}
