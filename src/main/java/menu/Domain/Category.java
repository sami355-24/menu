package menu.Domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static menu.Domain.Food.*;

public enum Category {
    JAPANESE(1, "일식",
            List.of("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼")),
    KOREAN(2, "한식",
            List.of("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음")),
    CHINESE(3, "중식",
            List.of("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채")),
    ASIAN(4, "아시안",
            List.of("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜")),
    WESTERN(5, "양식",
            List.of("스파게티", "라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "피자", "파니니"));

    private int id;
    private String name;
    private List<String> foods;
    private int count;

    Category(int id, String name, List<String> foods) {
        this.id = id;
        this.name = name;
        this.foods = foods;
        this.count = 0;
    }

    public static Category findRecommendCategory() {
        int count = 0;
        do {
//            Category category = getCategoryById(Randoms.pickNumberInRange(1, 5));
            String category = getCategoryById(Randoms.pickNumberInRange(1, 5));
            Category category_enum = Category.findCategoryByCategoryName(category);
            if (category_enum.count < 2) {
                category_enum.increaseCount();
                return category_enum;
            }
        }
        while (true);
    }

    private static String getCategoryById(int id) {
        return Arrays.stream(Category.values())
                .filter(category -> category.id == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 카테고리입니다."))
                .name;
    }

    private void increaseCount() {
        this.count++;
    }

    public Food findRecommendedFood(List<Food> recommendedFoods, List<Food> bannedFoods) {
        while (true) {
            List<String> shuffled = Randoms.shuffle(this.foods);
            Food findFood = Food.findFoodByName(shuffled.get(0));
            if (recommendedFoods.contains(findFood) || bannedFoods.contains(findFood)) {
                continue;
            }
            return findFood;
        }
    }

    static String findCategoryNameByFood(Food food) {
        Category[] categories = Category.values();
        for (Category category : categories) {
            List<String> foodsList = category.foods;
            for (String s : foodsList) {
                if (s.equals(food.getName())) {
                    return category.name;
                }
            }
        }

        throw new IllegalArgumentException("존재하지 않는 카테고리입니다.");
    }

    private static Category findCategoryByCategoryName(String categoryName) {
        return Arrays.stream(Category.values())
                .filter(category -> category.name.equals(categoryName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 카테고리입니다."));
    }

    public String getName() {
        return name;
    }

    public List<String> getFoods() {
        return Collections.unmodifiableList(foods);
    }

    public int getCount() {
        return count;
    }

    public int getId() {
        return id;
    }
}
