package baseball.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Input {
    public static String getInput() throws IllegalArgumentException {
        String input = Console.readLine();
        validateInput(input);
        return input;
    }

    public static void validateInput(String input) throws IllegalArgumentException {
        Pattern pattern = Pattern.compile("[1-9][1-9][1-9]");
        Matcher matcher = pattern.matcher(input);
        boolean matches = matcher.matches();
        if (!matches) {
            throw new IllegalArgumentException();
        }
    }
}
