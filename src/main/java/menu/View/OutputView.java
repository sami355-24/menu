package menu.View;

import static menu.Message.Prompt.END_MESSAGE;
import static menu.Message.Prompt.RECOMMEND_RESULT;
import static menu.Message.Prompt.SHOW_CATEGORY;
import static menu.Message.Prompt.SHOW_RECOMMEND_FOOD;
import static menu.Message.Prompt.SHOW_WEEK;
import static menu.Message.Prompt.WELL_COME_MESSAGE;

import java.util.List;

public class OutputView {

    public void printWellComeMessage() {
        System.out.println(WELL_COME_MESSAGE);
    }

    public void printRecommendResultHeader(List<String> categories) {
        System.out.println(RECOMMEND_RESULT);
        System.out.println(SHOW_WEEK);
        System.out.printf((SHOW_CATEGORY) + "%n", String.join(" | ", categories));
    }

    public void printRecommendResult(String coachName, List<String> recommendedFoods) {
        System.out.printf((SHOW_RECOMMEND_FOOD) + "%n", coachName, String.join(" | ", recommendedFoods));
    }

    public void printEndMessage() {
        System.out.println(END_MESSAGE);
    }
}
