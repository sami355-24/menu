package menu.Message.Excepton;


import static org.example.Message.Excepton.ExceptionPrefix.ERROR_PREFIX;

public enum ExceptionPrompt {
    INVALID_INPUT("유효하지 않은 입력입니다. 다시 입력해 주세요.");

    private final String prompt;

    ExceptionPrompt(String prompt) {
        this.prompt = prompt;
    }

    public String getPrompt() {
        return ERROR_PREFIX.getPrompt() + prompt;
    }
}