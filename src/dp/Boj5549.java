package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj5549 {
    private final static int MAX = 1001;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int dp[][][] = new int[MAX][MAX][3];
    private static char list[][] = new char[MAX][MAX];
    private static int N, M, K;

    private static void init() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                dp[i][j][0] = dp[i][j - 1][0] + dp[i - 1][j][0] - dp[i - 1][j - 1][0];
                dp[i][j][1] = dp[i][j - 1][1] + dp[i - 1][j][1] - dp[i - 1][j - 1][1];
                dp[i][j][2] = dp[i][j - 1][2] + dp[i - 1][j][2] - dp[i - 1][j - 1][2];

                if (list[i][j] == 'J') {
                    dp[i][j][0]++;
                } else if (list[i][j] == 'O') {
                    dp[i][j][1]++;
                } else {
                    dp[i][j][2]++;
                }
            }
        }
    }

    private static void func() throws Exception {
        init();

        StringBuffer sb = new StringBuffer();
        int sx, sy, ex, ey;
        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            sx = Integer.parseInt(st.nextToken());
            sy = Integer.parseInt(st.nextToken());
            ex = Integer.parseInt(st.nextToken());
            ey = Integer.parseInt(st.nextToken());

            sb.append(dp[ex][ey][0] - dp[ex][sy - 1][0] - dp[sx - 1][ey][0] + dp[sx - 1][sy - 1][0]).append(" ");
            sb.append(dp[ex][ey][1] - dp[ex][sy - 1][1] - dp[sx - 1][ey][1] + dp[sx - 1][sy - 1][1]).append(" ");
            sb.append(dp[ex][ey][2] - dp[ex][sy - 1][2] - dp[sx - 1][ey][2] + dp[sx - 1][sy - 1][2]).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            list[i] = (" " + st.nextToken()).toCharArray();
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
