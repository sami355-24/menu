package menu.Domain;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Coach {

    private String name;
    private List<Food> bannedFoods;
    private List<Food> recommendedFoods;

    public Coach(String name) {
        this.name = name;
        bannedFoods = new LinkedList<>();
        recommendedFoods = new LinkedList<>();
    }

    public void addBannedFood(Food food) {
        bannedFoods.add(food);
    }

    public String getName() {
        return name;
    }

    public List<Food> getBannedFoods() {
        return Collections.unmodifiableList(bannedFoods);
    }

    public List<Food> getRecommendedFoods() {
        return Collections.unmodifiableList(recommendedFoods);
    }
}
