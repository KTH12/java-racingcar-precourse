package racinggame.model;

import racinggame.common.exception.InvalidParamException;
import racinggame.common.response.ErrorCode;

public class TryCount {
    private static final String ONLY_NUMBER_REG_EXP = "^[0-9]+$";
    private final int count;
    private int tryCount;

    public TryCount(String input) {
        valid(input);
        this.count = Integer.parseInt(input);
    }

    public void incrementTryCount() {
        tryCount++;
    }

    public boolean isMax() {
        return tryCount == count;
    }

    public int getTryCount() {
        return tryCount;
    }

    private void valid(String input) {
        if (!input.matches(ONLY_NUMBER_REG_EXP)) {
            throw new InvalidParamException(ErrorCode.ONLY_NUMBER);
        }
    }
}
