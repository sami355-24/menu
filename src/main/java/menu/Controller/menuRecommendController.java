package menu.Controller;

import java.util.List;
import menu.Domain.Coach;
import menu.Domain.CoachGroup;
import menu.Domain.Food;
import menu.View.InputView;
import menu.View.OutputView;

public class menuRecommendController {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public void run() {
        outputView.printWellComeMessage();
        CoachGroup coachGroup = makeCoach();
        makeBannedFoods(coachGroup);
    }

    private CoachGroup makeCoach() {
        List<String> coachNames = inputView.inputCoachNames();
        return new CoachGroup(coachNames);
    }

    private static void makeBannedFoods(CoachGroup coachGroup) {
        List<Coach> coaches = coachGroup.getCoaches();
        coaches.forEach(coach -> {
            List<String> bannedFoods = inputView.inputBannedFoods(coach.getName());
            bannedFoods.stream()
                    .map(Food::findFoodByName)
                    .forEach(coach::addBannedFood);
        });

    }

}
