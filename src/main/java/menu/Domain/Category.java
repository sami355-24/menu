package menu.Domain;

import java.util.List;

import static menu.Domain.Food.*;

public enum Category {
    JAPANESE("일식",
            List.of(GYUDON, UDON, MISOSHIRU, SUSHI, KATSUDON, ONIGIRI, HAI_RICE, RAMEN, OKONOMIYAKI)),
    KOREAN("한식",
            List.of(GIMBAP, KIMCHI_JJIGAE, SSAMBAP, DOENJANG_JJIGAE,
                    BIBIMBAP, KALGUKSU, BULGOGI, TTEOKBOKKI, JEYUK_BOKKEUM)),
    CHINESE("중식",
            List.of(KKANPUNGHI, BOKKEUM_MYUN, DONGPO_PORK, JAJANGMYEON, JJAMPONG,
                    MAPO_TOFU, TANGSUYUK, TOMATO_EGG_STIR_FRY, GOCHU_JJAPCHAE)),
    ASIAN("아시안",
            List.of(PAD_THAI, KHAO_PAD, NASI_GORENG, PINEAPPLE_FRIED_RICE, PHO,
                    TOM_YUM_KUNG, BANH_MI, VIETNAMESE_SPRING_ROLLS, BUN_CHA)),
    WESTERN("양식",
            List.of(LASAGNA, GRATIN, NYOQUI, QUICHE, FRENCH_TOAST,
                    BAGUETTE, SPAGHETTI, PIZZA, PANINI));

    private String name;
    private List<Food> foods;

    Category(String name, List<Food> foods) {
        this.name = name;
        this.foods = foods;
    }

    public String getName() {
        return name;
    }

    public List<Food> getFoods() {
        return foods;
    }
}
