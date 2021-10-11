package racinggame.view;

import nextstep.utils.Console;
import racinggame.common.response.CommonMessage;

import java.util.Arrays;
import java.util.List;

public class UserInput {

    public static String readUserMessage() {
        return Console.readLine();
    }

    public static List<String> readUserMessageToArray() {
        return Arrays.asList(readUserMessage().split(CommonMessage.COMMA_SEPARATE.getMessage()));
    }
}
