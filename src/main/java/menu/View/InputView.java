package menu.View;

import static menu.Common.Validator.isValidCoachName;
import static menu.Message.Prompt.INPUT_COACH_NAME;

import java.util.List;
import menu.View.IO.Reader;

public class InputView {

    public List<String> inputCoachNames() {
        System.out.println(INPUT_COACH_NAME);
        String input = Reader.getString();
        isValidCoachName(input);
        return List.of(input.split(","));
    }

}
