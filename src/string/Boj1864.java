package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj1864 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static String str;

    private static int getInt(char x) {
        if (x == '-') return 0;
        else if (x == '\\') return 1;
        else if (x == '(') return 2;
        else if (x == '@') return 3;
        else if (x == '?') return 4;
        else if (x == '>') return 5;
        else if (x == '&') return 6;
        else if (x == '%') return 7;
        else return -1;
    }

    private static void func() {
        int len = str.length();
        int mul = (int) Math.pow(8, len - 1);
        int ret = 0;
        for (int i = 0; i < len; i++) {
            ret += (mul * getInt(str.charAt(i)));
            mul >>= 3;
        }

        System.out.println(ret);
    }

    private static void input() throws Exception {
        str = br.readLine();
        if ("#".equals(str)) System.exit(0);
    }

    public static void main(String[] args) throws Exception {
        while (true) {
            input();
            func();
        }
    }
}
