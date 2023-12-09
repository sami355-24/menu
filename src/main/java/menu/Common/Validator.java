package menu.Common;


import static menu.Message.Excepton.ExceptionPrompt.INVALID_INPUT;

import menu.Exception.CommonValidateException;

public class Validator {

    private static final String coachNamePattern = "^\\s*([가-힣]{2,4}\\s*,\\s*){1,4}[가-힣]{2,4}\\s*$";
    private static final String foodNamePattern = "^([^,]*,){0,2}[^,]*$";

    private Validator() {
    }

    public static void isValidCoachName(String str) {
        if (str == null || str.isEmpty()) {
            throw new CommonValidateException(INVALID_INPUT.getPrompt(), new IllegalArgumentException());
        }
        if (!str.matches(coachNamePattern)) {
            throw new CommonValidateException(INVALID_INPUT.getPrompt(), new IllegalArgumentException());
        }
    }

    public static void isValidFoodName(String str) {
        if (!str.matches(foodNamePattern)) {
            throw new CommonValidateException(INVALID_INPUT.getPrompt(), new IllegalArgumentException());
        }
    }
}
