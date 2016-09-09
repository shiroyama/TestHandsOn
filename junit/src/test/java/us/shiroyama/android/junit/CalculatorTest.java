package us.shiroyama.android.junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * {@link us.shiroyama.android.common.Calculator}のUnit Test
 */
public class CalculatorTest {
    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {

    }

    @Test
    public void 足し算が正しく出来る() throws Exception {
        // TODO 実装してみよう
    }

    @Test
    public void 引き算が正しく出来る() throws Exception {
        // TODO 実装してみよう
    }

    @Test
    public void 掛け算が正しく出来る() throws Exception {
        // TODO 実装してみよう
    }

    @Test
    public void 割り算が正しく出来る() throws Exception {
        // TODO 実装してみよう
    }

    @Test
    public void 割り算の第2引数が0ならばIllegalArgumentExceptionがthrowされる() {
        // TODO Calculatorに変更を追加したうえでテストを実装してみよう
    }
}
