package racinggame.view;

import racinggame.common.response.CommonMessage;

public class UserOutput {

    public static void print(String input) {
        System.out.println(input);
    }

    public static void listLoopPrint(List<String> listOutput) {
        for (String output : listOutput) {
            print(output);
        }
    }

    public static void printTtyCount() {
        System.out.println(CommonMessage.REQUIRE_TRY_COUNT.getMessage());
    }

    public static void printWinner(String winners) {
        System.out.printf((CommonMessage.WINNER_MESSAGE.getMessage()) + "%n", winners);
    }
}
