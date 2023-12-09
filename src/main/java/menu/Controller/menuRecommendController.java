package menu.Controller;

import java.util.List;
import menu.Domain.Category;
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
        for (int i = 0; i < 5; i++) {
            makeRecommendedFoods(coachGroup);
        }

        outputView.printRecommendResultHeader(coachGroup.findRecommendCategory());
        showRecommendResult(coachGroup);

        outputView.printEndMessage();
    }

    private CoachGroup makeCoach() {
        List<String> coachNames = inputView.inputCoachNames();
        return new CoachGroup(coachNames);
    }

    private void makeBannedFoods(CoachGroup coachGroup) {
        List<Coach> coaches = coachGroup.getCoaches();
        coaches.forEach(coach -> {
            List<String> bannedFoods = inputView.inputBannedFoods(coach.getName());
            bannedFoods.stream()
                    .map(Food::findFoodByName)
                    .forEach(coach::addBannedFood);
        });
    }

    private void makeRecommendedFoods(CoachGroup coachGroup) {
        List<Coach> coaches = coachGroup.getCoaches();
        Category recommendCategory = Category.findRecommendCategory();
        coaches.forEach(coach -> {
            Food recommendedFood = recommendCategory.findRecommendedFood(coach.getRecommendedFoods(), coach.getBannedFoods());
            coach.addRecommendedFood(recommendedFood);
        });
    }

    private void showRecommendResult(CoachGroup coachGroup) {
        List<Coach> coaches = coachGroup.getCoaches();
        coaches.forEach(coach -> outputView.printRecommendResult(coach.getName(), coach.makeRecommendFoodList()));
    }
}
