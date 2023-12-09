package menu.Controller;

import java.util.List;
import menu.View.InputView;
import menu.View.OutputView;

public class menuRecommendController {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public void run() {
        outputView.printWellComeMessage();
        List<String> coachNames = inputView.inputCoachNames();

    }
}
