package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj17202 {
    private final static int MAX = 9;
    private final static int MOD = 10;
    private static int dp[][] = new int[MAX << 1][MAX << 1];
    private static String phones[] = new String[2];
    private static int N;

    private static void init() {
        for (int i = 1; i <= N; i += 2) {
            dp[1][i] = phones[0].charAt((i - 1) >> 1) - '0';
            dp[1][i + 1] = phones[1].charAt((i - 1) >> 1) - '0';
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
        phones[0] = br.readLine();
        phones[1] = br.readLine();
        N = phones[0].length() * 2;
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
