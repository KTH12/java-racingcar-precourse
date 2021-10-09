package racinggame.model;

public class Engine {
    private static final int MIN_FRONT_POWER = 4;

    public boolean isValidFront(int power) {
        return power >= MIN_FRONT_POWER;
    }
}
