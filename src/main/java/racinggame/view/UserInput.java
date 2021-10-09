package racinggame.view;

import nextstep.utils.Console;
import racinggame.common.response.CommonMessage;
import racinggame.model.TryCount;

import java.util.Arrays;
import java.util.List;

public class UserInput {

    public static String readUserMessage() {
        return Console.readLine();
    }

    public static List<String> readUserMessageToArray() {
        return Arrays.asList(readUserMessage().split(CommonMessage.COMMA_SEPARATE.getMessage()));
    }

    public static TryCount readTryCount() {
        UserOutput.printTtyCount();
        String input = UserInput.readUserMessage();
        UserOutput.print(input);
        return new TryCount(input);
    }
}
