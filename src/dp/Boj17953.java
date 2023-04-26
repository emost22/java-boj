package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj17953 {
    private static int list[][], dp[][];
    private static int N, M;

    private static void func() {
        for (int i = 1; i <= M; i++) {
            dp[1][i] = list[1][i];
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                dp[i][j] = dp[i - 1][j] + list[i][j] / 2;
                for (int k = 1; k <= M; k++) {
                    if (j == k) continue;

                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][k] + list[i][j]);
                }
            }
        }

        int ret = 0;
        for (int i = 1; i <= M; i++) {
            ret = Math.max(ret, dp[N][i]);
        }

        System.out.println(ret);
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new int[N + 1][M + 1];
        dp = new int[N + 1][M + 1];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                list[j][i] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
