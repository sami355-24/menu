package menu.Message.Excepton;


import static menu.Message.Excepton.ExceptionPrefix.ERROR_PREFIX;

public enum ExceptionPrompt {
    INVALID_INPUT("유효하지 않은 입력입니다. 다시 입력해 주세요."),
    INVALID_COACH_NUMBER("코치는 최소 2명 이상 입력해야 합니다."),
    INVALID_FOOD_NAME("존재하지 않는 음식입니다.");

    private final String prompt;

    ExceptionPrompt(String prompt) {
        this.prompt = prompt;
    }

    public String getPrompt() {
        return ERROR_PREFIX.getPrompt() + prompt;
    }
}