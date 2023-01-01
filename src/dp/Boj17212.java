package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj17212 {
    private final static int M = 4;
    private final static int list[] = {1, 2, 5, 7};
    private static int dp[];
    private static int N;

    private static void func() {
        for (int i = 1; i <= N; i++) {
            dp[i] = i;
        }

        for (int i = 1; i < M; i++) {
            for (int j = 1; j <= N; j++) {
                if (j < list[i]) {
                    continue;
                }

                dp[j] = Math.min(dp[j], dp[j - list[i]] + 1);
            }
        }

        System.out.println(dp[N]);
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        dp = new int[N + 1];
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
