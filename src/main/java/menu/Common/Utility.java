package menu.Common;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Utility {

    private Utility() {
    }

    public static int convertStringToInt(String str) {
        return Integer.parseInt(str);
    }

}
