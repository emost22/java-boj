package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj27968 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static long dp[];
    private static int N, M;

    private static int getIndex(long x) {
        int l = 1;
        int r = N;
        while (l <= r) {
            int m = (l + r) / 2;
            if (dp[m] >= x) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return l;
    }

    private static void func() throws Exception {
        for (int i = 1; i <= N; i++) {
            dp[i] += dp[i - 1];
        }

        StringBuffer sb = new StringBuffer();
        long x;
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            x = Long.parseLong(st.nextToken());

            if (x > dp[N]) {
                sb.append("Go away!\n");
            } else {
                sb.append(getIndex(x)).append("\n");
            }
        }

        System.out.println(sb);
    }

    private static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        dp = new long[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            dp[i] = Long.parseLong(st.nextToken());
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
