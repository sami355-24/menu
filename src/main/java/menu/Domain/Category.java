package menu.Domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static menu.Domain.Food.*;

public enum Category {
    JAPANESE(1, "일식",
            List.of(GYUDON, UDON, MISOSHIRU, SUSHI, KATSUDON, ONIGIRI, HAI_RICE, RAMEN, OKONOMIYAKI)),
    KOREAN(2, "한식",
            List.of(GIMBAP, KIMCHI_JJIGAE, SSAMBAP, DOENJANG_JJIGAE,
                    BIBIMBAP, KALGUKSU, BULGOGI, TTEOKBOKKI, JEYUK_BOKKEUM)),
    CHINESE(3, "중식",
            List.of(KKANPUNGHI, BOKKEUM_MYUN, DONGPO_PORK, JAJANGMYEON, JJAMPONG,
                    MAPO_TOFU, TANGSUYUK, TOMATO_EGG_STIR_FRY, GOCHU_JJAPCHAE)),
    ASIAN(4, "아시안",
            List.of(PAD_THAI, KHAO_PAD, NASI_GORENG, PINEAPPLE_FRIED_RICE, PHO,
                    TOM_YUM_KUNG, BANH_MI, VIETNAMESE_SPRING_ROLLS, BUN_CHA)),
    WESTERN(5, "양식",
            List.of(LASAGNA, GRATIN, NYOQUI, QUICHE, FRENCH_TOAST,
                    BAGUETTE, SPAGHETTI, PIZZA, PANINI));

    private int id;
    private String name;
    private List<Food> foods;
    private int count;

    Category(int id, String name, List<Food> foods) {
        this.id = id;
        this.name = name;
        this.foods = foods;
        this.count = 0;
    }

    public static Category findRecommendCategory() {
        int count = 0;
        do {
            Category category = getCategoryById(Randoms.pickNumberInRange(1, 5));
            if (category.count < 2) {
                category.increaseCount();
                return category;
            }
        }
        while (true);
    }

    private static Category getCategoryById(int id) {
        return Arrays.stream(Category.values())
                .filter(category -> category.id == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 카테고리입니다."));
    }

    private void increaseCount() {
        this.count++;
    }

    public Food findRecommendedFood(List<Food> recommendedFoods, List<Food> bannedFoods) {
        while (true) {
            List<Food> shuffledFood = Randoms.shuffle(this.foods);
            if (recommendedFoods.contains(shuffledFood.get(0)) || bannedFoods.contains(shuffledFood.get(0))) {
                continue;
            }
            return shuffledFood.get(0);
        }
    }

    static String findCategoryNameByFood(Food food) {
        return Arrays.stream(Category.values())
                .filter(category -> category.foods.contains(food))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 카테고리입니다."))
                .name;
    }

    public String getName() {
        return name;
    }

    public List<Food> getFoods() {
        return Collections.unmodifiableList(foods);
    }

    public int getCount() {
        return count;
    }

    public int getId() {
        return id;
    }
}
