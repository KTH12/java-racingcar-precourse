package racinggame.model;

import racinggame.common.exception.InvalidParamException;
import racinggame.common.response.ErrorCode;

public class CarName {
    public static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public CarName(String name) {
        valid(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void valid(String name) {
        if (name.isEmpty()) {
            throw new InvalidParamException(ErrorCode.EMPTY_ERROR);
        }
        if (isLengthOver(name)) {
            throw new InvalidParamException(ErrorCode.CAR_NAME_SIZE_OVER);
        }
    }

    private boolean isLengthOver(String name) {
        return name.length() > MAX_NAME_LENGTH;
    }
}
