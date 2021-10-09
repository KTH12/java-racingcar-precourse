package racinggame.view;

import nextstep.utils.Console;

import java.util.Arrays;
import java.util.List;

public class UserInput {
    private static final String COMMA = ",";

    public static String readUserMessage() {
        return Console.readLine();
    }

    public static List<String> readUserMessageToArray() {
        return Arrays.asList(readUserMessage().split(COMMA));
    }
}
