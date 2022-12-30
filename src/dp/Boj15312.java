package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj15312 {
    private final static int alphaCnt[] = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};
    private final static int MAX = 2001;
    private final static int MOD = 10;
    private static int dp[][] = new int[MAX * 2][MAX * 2];
    private static String names[] = new String[2];
    private static int N;

    private static void init() {
        for (int i = 1; i <= N; i += 2) {
            dp[1][i] = alphaCnt[names[0].charAt((i - 1) >> 1) - 'A'];
            dp[1][i + 1] = alphaCnt[names[1].charAt((i - 1) >> 1) - 'A'];
        }
    }

    private static void func() {
        init();
        for (int i = 2; i < N; i++) {
            for (int j = i; j <= N; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % MOD;
            }
        }

        System.out.print(dp[N - 1][N - 1]);
        System.out.println(dp[N - 1][N]);
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        names[0] = br.readLine();
        names[1] = br.readLine();
        N = names[0].length() * 2;
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
