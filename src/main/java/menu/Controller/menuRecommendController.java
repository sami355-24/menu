package menu.Controller;

import java.util.List;
import menu.Domain.CoachGroup;
import menu.View.InputView;
import menu.View.OutputView;

public class menuRecommendController {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public void run() {
        outputView.printWellComeMessage();
        makeCoach();
    }

    private CoachGroup makeCoach() {
        List<String> coachNames = inputView.inputCoachNames();
        return new CoachGroup(coachNames);
    }
}
