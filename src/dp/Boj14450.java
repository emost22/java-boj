package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj14450 {
    private final static int MAX_N = 100001;
    private final static int MAX_K = 21;
    private static final int RACE_CNT = 3;
    private static int list[] = new int[MAX_N];
    private static int dp[][][] = new int[MAX_N][MAX_K][RACE_CNT];
    private static int N, K;

    private static void init() {
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= K; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
    }

    private static int getScore(int x, int y) {
        if (x == 0 && y == 1) {
            return 1;
        } else if (x == 1 && y == 2) {
            return 1;
        } else if (x == 2 && y == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    private static int dfs(int idx, int cnt, int race) {
        if (idx > N) {
            return 0;
        }
        if (dp[idx][cnt][race] != -1) {
            return dp[idx][cnt][race];
        }

        dp[idx][cnt][race] = dfs(idx + 1, cnt, race) + getScore(race, list[idx]);
        if (cnt < K) {
            dp[idx][cnt][race] = Math.max(dp[idx][cnt][race], dfs(idx + 1, cnt + 1, (race + 1) % RACE_CNT) + getScore(race, list[idx]));
            dp[idx][cnt][race] = Math.max(dp[idx][cnt][race], dfs(idx + 1, cnt + 1, (race + 2) % RACE_CNT) + getScore(race, list[idx]));
        }

        return dp[idx][cnt][race];
    }

    private static void func() {
        init();
        System.out.println(Math.max(dfs(1, 0, 0), Math.max(dfs(1, 0, 1), dfs(1, 0, 2))));
    }

    private static int getRace(char x) {
        if (x == 'H') {
            return 0;
        } else if (x == 'S') {
            return 1;
        } else {
            return 2;
        }
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            list[i] = getRace(st.nextToken().charAt(0));
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
