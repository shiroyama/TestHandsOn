package us.shiroyama.android.junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import us.shiroyama.android.common.Calculator;

import static org.junit.Assert.assertTrue;

/**
 * {@link us.shiroyama.android.common.Calculator}のUnit Test
 */
public class CalculatorTest {
    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @After
    public void tearDown() {

    }

    @Test
    public void 足し算が正しく出来る() throws Exception {
        double expected = calculator.add(1.0, 2.0);
        assertTrue(expected == 3.0);
    }

    @Test
    public void 引き算が正しく出来る() throws Exception {
        double expected = calculator.subtract(1.0, 2.0);
        assertTrue(expected == -1.0);
    }

    @Test
    public void 掛け算が正しく出来る() throws Exception {
        double expected = calculator.multiply(1.0, 2.0);
        assertTrue(expected == 2.0);
    }

    @Test
    public void 割り算が正しく出来る() throws Exception {
        double expected = calculator.divide(1.0, 2.0);
        assertTrue(expected == 0.5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 割り算の第2引数が0ならばIllegalArgumentExceptionがthrowされる() {
        calculator.divide(1.0, 0);
    }
}
