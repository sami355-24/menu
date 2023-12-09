package menu;

import menu.Controller.MenuRecommendController;
import menu.Controller.MenuRecommendControllerDeco;

public class Application {
    public static void main(String[] args) {
        MenuRecommendController menuRecommendController = new MenuRecommendControllerDeco();
        menuRecommendController.run();
    }
}
