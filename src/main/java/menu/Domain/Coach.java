package menu.Domain;

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
}
