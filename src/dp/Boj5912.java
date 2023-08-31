package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj5912 {
    private static int dp[];
    private static int N, K;

    private static void func() {
        for (int i = 1; i <= N; i++) {
            dp[i] += dp[i - 1];
        }

        Arrays.sort(dp, 1, N + 1);
        System.out.println(dp[(N + 1) >> 1]);
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dp = new int[N + 2];

        int l, r;
        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());

            dp[l]++;
            dp[r + 1]--;
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
