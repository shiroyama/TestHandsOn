package us.shiroyama.android.mockito;

import java.util.Random;

/**
 * ランダムなint整数を生成する
 */
public class RandomIntGenerator {
    private final Random random = new Random();

    public int generate() {
        return random.nextInt(Integer.MAX_VALUE);
    }
}
