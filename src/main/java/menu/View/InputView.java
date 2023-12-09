package menu.View;

import static menu.Common.Validator.isValidCoachName;
import static menu.Common.Validator.isValidFoodName;
import static menu.Message.Prompt.INPUT_BANNED_FOOD;
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

    public List<String> inputBannedFoods(String coachName) {
        System.out.printf((INPUT_BANNED_FOOD) + "%n", coachName);
        String input = Reader.getString();
        isValidFoodName(input);
        return List.of(input.split(","));
    }
}
