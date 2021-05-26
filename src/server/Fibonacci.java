package server;

import java.math.BigInteger;

class Fibonacci {
    public static BigInteger calculation (int n) {
        BigInteger  a = new BigInteger("0");
        BigInteger  b = new BigInteger("1");
        for (int i = 0; i < n; i++) {
            BigInteger  c = a.add(b);
            a = b;
            b = c;
        }
        return a;
    }
}
