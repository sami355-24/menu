package menu.Domain;

import java.util.Arrays;

public enum Food {
    GYUDON("규동"),
    UDON("우동"),
    MISOSHIRU("미소시루"),
    SUSHI("스시"),
    KATSUDON("카츠동"),
    ONIGIRI("오니기리"),
    HAI_RICE("하이라이스"),
    RAMEN("라면"),
    OKONOMIYAKI("오코노미야끼"),

    GIMBAP("김밥"),
    KIMCHI_JJIGAE("김치찌개"),
    SSAMBAP("쌈밥"),
    DOENJANG_JJIGAE("된장찌개"),
    BIBIMBAP("비빔밥"),
    KALGUKSU("칼국수"),
    BULGOGI("불고기"),
    TTEOKBOKKI("떡볶이"),
    JEYUK_BOKKEUM("제육볶음"),

    KKANPUNGHI("깐풍기"),
    BOKKEUM_MYUN("볶음면"),
    DONGPO_PORK("동파육"),
    JAJANGMYEON("짜장면"),
    JJAMPONG("짬뽕"),
    MAPO_TOFU("마파두부"),
    TANGSUYUK("탕수육"),
    TOMATO_EGG_STIR_FRY("토마토 달걀볶음"),
    GOCHU_JJAPCHAE("고추잡채"),

    PAD_THAI("팟타이"),
    KHAO_PAD("카오 팟"),
    NASI_GORENG("나시고렝"),
    PINEAPPLE_FRIED_RICE("파인애플 볶음밥"),
    PHO("쌀국수"),
    TOM_YUM_KUNG("똠얌꿍"),
    BANH_MI("반미"),
    VIETNAMESE_SPRING_ROLLS("월남쌈"),
    BUN_CHA("분짜"),

    LASAGNA("라자냐"),
    GRATIN("그라탱"),
    NYOQUI("뇨끼"),
    QUICHE("끼슈"),
    FRENCH_TOAST("프렌치 토스트"),
    BAGUETTE("바게트"),
    SPAGHETTI("스파게티"),
    PIZZA("피자"),
    PANINI("파니니");

    private String name;

    Food(String name) {
        this.name = name;
    }

    public static Food findFoodByName(String name) {
        return Arrays.stream(Food.values())
                .filter(food -> food.name.equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 음식입니다."));
    }

    public String getName() {
        return name;
    }
}
