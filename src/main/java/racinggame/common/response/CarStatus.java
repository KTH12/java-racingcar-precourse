package racinggame.common.response;

public enum CarStatus {
    NEW_RECORD(1), TIE_RECORD(2), DEFEAT(3);

    private final int status;

    CarStatus(int status) {
        this.status = status;
    }

    public static boolean isNewRecord(CarStatus racingStatus) {
        return NEW_RECORD == racingStatus;
    }

    public static boolean isDefeat(CarStatus racingStatus) {
        return DEFEAT == racingStatus;
    }

    public int getStatus() {
        return status;
    }
}
