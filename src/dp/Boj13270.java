package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj13270 {
    private static final int MAX = 1000000000;
    private static int[] mn, mx;
    private static int N;

    private static void init() {
        for (int i = 1; i <= N; i++) {
            mn[i] = MAX;
        }
    }

    private static void func() {
        init();

        int a = 2;
        int b = 1;
        while (a <= N) {
            for (int i = a; i <= N; i++) {
                mn[i] = Math.min(mn[i], mn[i - a] + b);
                mx[i] = Math.max(mx[i], mx[i - a] + b);
            }

            int tmp = a + b;
            b = a;
            a = tmp;
        }

        System.out.println(mn[N] + " " + mx[N]);
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        mn = new int[N + 1];
        mx = new int[N + 1];
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
