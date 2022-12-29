package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj14453 {
    private static class Point{
        int pCnt;
        int hCnt;
        int sCnt;

        public Point(int p, int h, int s) {
            pCnt = p;
            hCnt = h;
            sCnt = s;
        }
    }

    private static final int MAX = 100001;
    private static Point[] dp = new Point[MAX];
    private static int N;

    private static void func() {
        int ret = Math.max(dp[N].pCnt, Math.max(dp[N].hCnt, dp[N].sCnt));
        for(int i = 1; i < N; i++) {
            int l = Math.max(dp[i].pCnt, Math.max(dp[i].hCnt, dp[i].sCnt));
            int r = Math.max(dp[N].pCnt - dp[i].pCnt, Math.max(dp[N].hCnt - dp[i].hCnt, dp[N].sCnt - dp[i].sCnt));

            ret = Math.max(ret, l + r);
        }

        System.out.println(ret);
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        char x;
        N = Integer.parseInt(st.nextToken());
        dp[0] = new Point(0, 0, 0);
        for (int i = 1; i <= N; i++) {
            dp[i] = new Point(0, 0, 0);
            st = new StringTokenizer(br.readLine());
            x = st.nextToken().charAt(0);

            if (x == 'P') {
                dp[i].pCnt++;
            } else if (x == 'H') {
                dp[i].hCnt++;
            } else {
                dp[i].sCnt++;
            }

            dp[i].pCnt += dp[i - 1].pCnt;
            dp[i].hCnt += dp[i - 1].hCnt;
            dp[i].sCnt += dp[i - 1].sCnt;
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
