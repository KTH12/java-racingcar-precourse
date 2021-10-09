package racinggame.common.response;

public enum ErrorCode {
    COMMON_INVALID_PARAMETER("요청한 값이 올바르지 않습니다."),
    CAR_NAME_SIZE_OVER(String.format("자동차 이름은 %s자 까지 가능합니다.", 5));

    private final String errorMsg;

    ErrorCode(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg(Object... arg) {
        return String.format(errorMsg, arg);
    }
}
