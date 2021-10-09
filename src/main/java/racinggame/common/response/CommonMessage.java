package racinggame.common.response;

public enum CommonMessage {
    WINNER_MESSAGE("최종 우승자는 %s 입니다."),
    REQUIRE_TRY_COUNT("시도할 회수는 몇회인가요?"),
    REQUIRE_CAR_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    RESULT_MESSAGE("실행결과"),
    COMMA_SEPARATE(","),
    ;

    private final String message;

    CommonMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
