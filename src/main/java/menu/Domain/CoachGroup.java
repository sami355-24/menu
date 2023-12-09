package menu.Domain;

import static menu.Message.Excepton.ExceptionPrompt.INVALID_INPUT;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class CoachGroup {
    private List<Coach> coaches;

    public CoachGroup(List<String> coaches) {
        this.coaches = new LinkedList<>();
        if (coaches.size() != new HashSet<>(coaches).size()) {
            throw new IllegalArgumentException(INVALID_INPUT.getPrompt());
        }
        for (String coach : coaches) {
            this.coaches.add(new Coach(coach));
        }
    }

    public List<Coach> getCoaches() {
        return Collections.unmodifiableList(coaches);
    }
}
