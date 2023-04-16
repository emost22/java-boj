package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj10174 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    private static String str;

    private static char getLower(char x) {
        if ('A' <= x && x <= 'Z') return (char) (x + 32);
        else return x;
    }

    private static void func() {
        int len = str.length();
        int l = 0;
        int r = len - 1;
        while (l < r) {
            if (getLower(str.charAt(l++)) != getLower(str.charAt(r--))) {
                System.out.println("No");
                return;
            }
        }

        System.out.println("Yes");
    }

    private static void input() throws Exception {
        str = br.readLine();
    }

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        while (N-- > 0) {
            input();
            func();
        }
    }
}
