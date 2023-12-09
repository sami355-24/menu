package menu.Domain;

import java.util.EnumMap;
import java.util.Map;

public class CategoryHistory {

    private Map<Category, Integer> history;

    public CategoryHistory() {
        history = new EnumMap<>(Category.class);
        for (Category category : Category.values()) {
            history.put(category, 0);
        }
    }

    public boolean isAvailable(Category category) {
        return history.get(category) < 2;
    }

    public void addHistory(Category category) {
        history.put(category, history.get(category) + 1);
    }
}
