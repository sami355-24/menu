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

    public void addRecommendedFood(Food food) {
        recommendedFoods.add(food);
    }

    public List<String> findRecommendedCategory() {
        List<String> categoryNames = new LinkedList<>();
        for (Food food : recommendedFoods) {
            categoryNames.add(Category.findCategoryNameByFood(food));
        }
        return categoryNames;
    }

    public List<String> makeRecommendFoodList() {
        List<String> recommendFoodList = new LinkedList<>();
        for (Food food : recommendedFoods) {
            recommendFoodList.add(food.getName());
        }
        return recommendFoodList;
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
