package us.shiroyama.android.mockito;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * {@link RandomIntGenerator}のテスト
 */
public class RandomIntGeneratorTest {
    private RandomIntGenerator randomIntGenerator;

    @Before
    public void setUp() {
        randomIntGenerator = new RandomIntGenerator();
    }

    @After
    public void tearDown() {

    }

    @Test
    public void generateの結果をmockしてテスト可能にする() {
        // TODO Mockitoを使って実装する
    }
}
