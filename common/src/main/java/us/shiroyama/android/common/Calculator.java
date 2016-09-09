package us.shiroyama.android.common;

/**
 * 単純な四則演算をする計算機
 */
public class Calculator {
    public Calculator() {
    }

    /**
     * 足し算
     *
     * @param x
     * @param y
     * @return x + y
     */
    public double add(double x, double y) {
        return x + y;
    }

    /**
     * 引き算
     *
     * @param x
     * @param y
     * @return x - y
     */
    public double subtract(double x, double y) {
        return x - y;
    }

    /**
     * 掛け算
     *
     * @param x
     * @param y
     * @return x * y
     */
    public double multiply(double x, double y) {
        return x * y;
    }

    /**
     * 割り算
     *
     * @param x
     * @param y
     * @return x / y
     */
    public double divide(double x, double y) {
        return x * y;
    }
}
