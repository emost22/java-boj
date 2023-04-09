package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj13235 {
    private static String str;
    private static int N;

    private static void func() {
        int l = 0;
        int r = N - 1;
        while (l < r) {
            if (str.charAt(l++) != str.charAt(r--)) {
                System.out.println("false");
                return;
            }
        }

        System.out.println("true");
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        N = str.length();
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
