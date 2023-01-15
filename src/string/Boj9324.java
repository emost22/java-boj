package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj9324 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int alphaCnt[] = new int[26];
    private static String str;

    private static void init() {
        Arrays.fill(alphaCnt, 0);
    }

    private static void func() {
        int len = str.length();
        for (int i = 0; i < len; i++) {
            char x = str.charAt(i);
            int idx = x - 'A';
            alphaCnt[idx]++;
            if (alphaCnt[idx] == 3) {
                if (i == len - 1 || str.charAt(i + 1) != x) {
                    System.out.println("FAKE");
                    return;
                }
                i++;
                alphaCnt[idx] = 0;
            }
        }

        System.out.println("OK");
    }

    private static void input() throws Exception {
        str = br.readLine();
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int tc = Integer.parseInt(st.nextToken());
        while (tc-- > 0) {
            input();
            func();
            init();
        }
    }
}
