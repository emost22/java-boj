package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj24552 {
    private static String str;

    private static void func() {
        int len = str.length();
        int l = 0;
        int r = 0;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == '(') {
                l++;
                sum++;
            } else {
                r++;
                sum--;
            }

            if (sum < 0) {
                System.out.println(r);
                return;
            }

            if (sum == 0) {
                l = 0;
            }
        }

        System.out.println(l);
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
