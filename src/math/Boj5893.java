package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Boj5893 {
    static String str = new String();

    static void func() {
        BigInteger x = new BigInteger(str, 2).multiply(BigInteger.valueOf(17));

        str = "";
        while (true) {
            str += x.mod(BigInteger.valueOf(2));
            x = x.divide(BigInteger.valueOf(2));

            if (x.equals(BigInteger.ZERO)) break;
        }

        System.out.println(new StringBuffer(str).reverse());
    }

    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
