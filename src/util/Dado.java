package util;
import java.util.Random;

public class Dado {
    private static final Random random = new Random();

    public static int jogar() {
        return random.nextInt(6) + 1;
    }
}
