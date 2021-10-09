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
        if (name.length() > MAX_NAME_LENGTH) {
            throw new InvalidParamException(ErrorCode.CAR_NAME_SIZE_OVER);
        }
    }
}
