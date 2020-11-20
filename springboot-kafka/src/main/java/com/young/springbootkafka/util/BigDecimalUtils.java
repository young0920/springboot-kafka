package com.young.springbootkafka.util;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * BigDecimalUtils
 *
 * @author yangbing
 * @date 2020/11/20 上午11:47
 */
public class BigDecimalUtils {
    /**
     * 开次方
     *
     * @param number       被开次方数
     * @param n            开n次方
     * @param scale        保留小数
     * @param roundingMode 摄入模式  四舍五入
     * @return bigDecimal
     */
    private static BigDecimal bigRoot(BigDecimal number, int n, int scale, int roundingMode) {
        boolean negate = false;
        if (n < 0) {
            throw new ArithmeticException();
        }
        if (number.compareTo(BigDecimal.ZERO) < 0) {
            if (n % 2 == 0) {
                throw new ArithmeticException();
            } else {
                number = number.negate();
                negate = true;
            }
        }

        BigDecimal root;

        if (n == 0) {
            root = BigDecimal.ONE;
        } else if (n == 1) {
            root = number;
        } else {
            final BigInteger finBi1 = BigInteger.valueOf(n);
            final BigInteger finBi2 = BigInteger.TEN.pow(n);
            final BigInteger finBi3 = BigInteger.TEN.pow(n - 1);
            final BigInteger finBi = BigInteger.valueOf(9);

            BigInteger[] arrayBi = new BigInteger[n + 1];
            for (int i = 0; i <= n; i++) {
                arrayBi[i] = combination(n, i);
            }

            BigInteger integer = number.toBigInteger();
            String strInt = integer.toString();
            int lenInt = strInt.length();
            for (int i = lenInt % n; i < n && i > 0; i++) {
                strInt = "0" + strInt;
            }
            lenInt = (lenInt + n - 1) / n * n;
            BigDecimal fraction = number.subtract(number.setScale(0, BigDecimal.ROUND_DOWN));
            int lenFrac = (fraction.scale() + n - 1) / n * n;
            fraction = fraction.movePointRight(lenFrac);
            String strFrac = fraction.toPlainString();
            for (int i = strFrac.length(); i < lenFrac; i++) {
                strFrac = "0" + strFrac;
            }
            BigInteger res = BigInteger.ZERO;
            BigInteger rem = BigInteger.ZERO;
            for (int i = 0; i < lenInt / n; i++) {
                rem = rem.multiply(finBi2);

                BigInteger temp = new BigInteger(strInt.substring(i * n, i * n + n));
                rem = rem.add(temp);

                BigInteger j;
                if (res.compareTo(BigInteger.ZERO) != 0) {
                    j = rem.divide(res.pow(n - 1).multiply(finBi1).multiply(finBi3));
                } else {
                    j = finBi;
                }
                BigInteger test = BigInteger.ZERO;
                temp = res.multiply(BigInteger.TEN);
                while (j.compareTo(BigInteger.ZERO) >= 0) {
                    test = BigInteger.ZERO;
                    if (j.compareTo(BigInteger.ZERO) > 0) {
                        for (int k = 1; k <= n; k++) {
                            test = test.add(j.pow(k).multiply(arrayBi[k]).multiply(temp.pow(n - k)));
                        }
                    }
                    if (test.compareTo(rem) <= 0) {
                        break;
                    }
                    j = j.subtract(BigInteger.ONE);
                }

                rem = rem.subtract(test);
                res = res.multiply(BigInteger.TEN);
                res = res.add(j);
            }
            for (int i = 0; i <= scale; i++) {
                rem = rem.multiply(finBi2);

                if (i < lenFrac / n) {
                    BigInteger temp = new BigInteger(strFrac.substring(i * n, i * n + n));
                    rem = rem.add(temp);
                }

                BigInteger j;
                if (res.compareTo(BigInteger.ZERO) != 0) {
                    j = rem.divide(res.pow(n - 1).multiply(finBi1).multiply(finBi3));
                } else {
                    j = finBi;
                }
                BigInteger test = BigInteger.ZERO;
                BigInteger temp = res.multiply(BigInteger.TEN);
                while (j.compareTo(BigInteger.ZERO) >= 0) {
                    test = BigInteger.ZERO;
                    if (j.compareTo(BigInteger.ZERO) > 0) {
                        for (int k = 1; k <= n; k++) {
                            test = test.add(j.pow(k).multiply(arrayBi[k]).multiply(temp.pow(n - k)));
                        }
                    }
                    if (test.compareTo(rem) <= 0) {
                        break;
                    }
                    j = j.subtract(BigInteger.ONE);
                }

                rem = rem.subtract(test);
                res = res.multiply(BigInteger.TEN);
                res = res.add(j);
            }
            root = new BigDecimal(res).movePointLeft(scale + 1);
            if (negate) {
                root = root.negate();
            }
        }
        return root.setScale(scale, roundingMode);
    }

    private static BigInteger combination(int n, int k) {
        if (k > n || n < 0 || k < 0) {
            return BigInteger.ZERO;
        }
        if (k > n / 2) {
            return combination(n, n - k);
        }
        BigInteger bi1 = BigInteger.ONE;
        BigInteger bi2 = BigInteger.ONE;
        BigInteger bin = BigInteger.valueOf(n);
        BigInteger bik = BigInteger.valueOf(k);
        for (int i = 0; i < k; i++) {
            bi1 = bi1.multiply(bin);
            bi2 = bi2.multiply(bik);
            bin = bin.subtract(BigInteger.ONE);
            bik = bik.subtract(BigInteger.ONE);
        }
        return bi1.divide(bi2);
    }

    /**
     * BigDecimal 开n次方
     *
     * @param num     被开次方数
     * @param n       开次方数
     * @param decimal 小数点精度
     * @return res
     */
    public static BigDecimal getPower(BigDecimal num, int n, int decimal) {
        //  BigDecimal.ROUND_HALF_UP  四舍五入
        return bigRoot(num, n, decimal, BigDecimal.ROUND_HALF_UP);
    }
}
