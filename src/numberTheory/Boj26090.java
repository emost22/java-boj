package numberTheory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj26090 {
    private final static int MAX_V = 1000001;
    private final static int MAX_N = 501;
    private static boolean isNotPrime[] = new boolean[MAX_V];
    private static int dp[] = new int[MAX_N];
    private static int N;

    private static void init() {
        isNotPrime[0] = true;
        isNotPrime[1] = true;
        for (int i = 2; i * i < MAX_V; i++) {
            if (isNotPrime[i]) continue;

            for (int j = 2; i * j < MAX_V; j++) {
                isNotPrime[i * j] = true;
            }
        }
    }

    private static void func() {
        init();

        int ret = 0;
        for (int i = 1; i < N; i++) {
            for (int j = i + 1; j <= N; j++) {
                if (isNotPrime[j - i + 1]) continue;

                if (!isNotPrime[dp[j] - dp[i - 1]]) {
                    ret++;
                }
            }
        }

        System.out.println(ret);
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            dp[i] = Integer.parseInt(st.nextToken());
            dp[i] += dp[i - 1];
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
