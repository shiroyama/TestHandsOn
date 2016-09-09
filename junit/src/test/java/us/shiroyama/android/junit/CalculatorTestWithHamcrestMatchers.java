package us.shiroyama.android.junit;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import us.shiroyama.android.common.Calculator;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

/**
 * {@link Calculator}のUnit Test
 */
public class CalculatorTestWithHamcrestMatchers {
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
        assertThat(expected, is(3.0));
    }

    @Test
    public void 引き算が正しく出来る() throws Exception {
        double expected = calculator.subtract(1.0, 2.0);
        assertThat(expected, is(-1.0));
    }

    @Test
    public void 掛け算が正しく出来る() throws Exception {
        double expected = calculator.multiply(1.0, 2.0);
        assertThat(expected, is(2.0));
    }

    @Test
    public void 割り算が正しく出来る() throws Exception {
        double expected = calculator.divide(1.0, 2.0);
        assertThat(expected, is(0.5));
    }
}
