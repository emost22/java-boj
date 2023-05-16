package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj25427_2 {
    private final static int MAX = 100000;
    private final static char pat[] = new char[]{'D', 'K', 'S', 'H'};
    private static char[] list;
    private static long dp[][] = new long[MAX][4];
    private static int N;

    private static long solve(int idx, int pos) {
        if (pos == 4) return 1;
        if (idx == N) return 0;
        if (dp[idx][pos] != -1) return dp[idx][pos];
        dp[idx][pos] = solve(idx + 1, pos);

        if (list[idx] == pat[pos]) {
            dp[idx][pos] += solve(idx + 1, pos + 1);
        }

        return dp[idx][pos];
    }

    private static void init() {
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }
    }

    private static void func() {
        init();
        System.out.println(solve(0, 0));
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        list = st.nextToken().toCharArray();
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
