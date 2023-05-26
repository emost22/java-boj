package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj25706 {
    private final static int MAX = 200001;
    private static int list[] = new int[MAX];
    private static int dp[] = new int[MAX];
    private static int N;

    private static void func() {
        for (int i = N; i >= 1; i--) {
            dp[i] = 1;
            if (i + list[i] + 1 <= N) {
                dp[i] += dp[i + list[i] + 1];
            }
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= N; i++) {
            sb.append(dp[i]).append(" ");
        }
        System.out.println(sb.toString());
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
