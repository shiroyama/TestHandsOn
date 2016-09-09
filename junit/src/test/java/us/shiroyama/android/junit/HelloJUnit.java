package us.shiroyama.android.junit;

import org.junit.Assert;
import org.junit.Test;

/**
 * {@link org.junit.Assert}に触れてみるだけのテスト
 */
public class HelloJUnit {
    @Test
    public void intの数値が同じであることを検証する例題() throws Exception {
        int i = 123;
        Assert.assertEquals(i, 123);
    }

    @Test
    public void 文字列が同じであることを検証() throws Exception {
        String expected = "hello assertion";
        // TODO 実装してみよう
    }

    @Test
    public void assertTrueメソッドを使って何か真偽値を検証してみよう() throws Exception {
        // TODO 実装してみよう
    }
}
