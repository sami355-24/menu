package menu.Controller;

import menu.Domain.CoachGroup;

public class MenuRecommendControllerDeco extends MenuRecommendController {

    public MenuRecommendControllerDeco() {
        super();
    }

    public void run() {
        super.run();
    }

    @Override
    protected CoachGroup makeCoach() {
        while (true) {
            try {
                return super.makeCoach();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    protected void makeBannedFoods(CoachGroup coachGroup) {
        while (true) {
            try {
                super.makeBannedFoods(coachGroup);
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
