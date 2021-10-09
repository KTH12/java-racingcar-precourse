package racinggame.view;

import racinggame.common.response.CommonMessage;

public class UserOutput {

    public static void print(String input) {
        System.out.println(input);
    }

    public static void printTtyCount() {
        System.out.println(CommonMessage.REQUIRE_TRY_COUNT.getMessage());
    }
}
