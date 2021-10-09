package racinggame.model;

import java.security.InvalidParameterException;

public class CarName {
    private static final int MAX_NAME_LENGTH = 5;
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
            throw new InvalidParameterException(String.format("이름은 %s자 이하로 설정할 수 있습니다.", MAX_NAME_LENGTH));
        }
    }
}
