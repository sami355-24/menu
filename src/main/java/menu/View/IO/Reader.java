package menu.View.IO;

import camp.nextstep.edu.missionutils.Console;

public class Reader {

    private Reader() {
    }

    public static String getString() {
        return Console.readLine();
    }

}
