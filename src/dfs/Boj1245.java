package dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1245 {
    private final static int MAX_N = 101;
    private final static int MAX_M = 71;
    private static int list[][] = new int[MAX_N][MAX_M];
    private static int direct[][] = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
    private static boolean visit[][] = new boolean[MAX_N][MAX_M];
    private static boolean isMaru;
    private static int N, M;

    private static void dfs(int x, int y) {
        visit[x][y] = true;
        for (int d = 0; d < 8; d++) {
            int nx = x + direct[d][0];
            int ny = y + direct[d][1];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if (list[x][y] < list[nx][ny]) isMaru = false;
            if (visit[nx][ny] || list[x][y] != list[nx][ny]) continue;

            dfs(nx, ny);
        }
    }

    private static void func() {
        int ret = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visit[i][j]) continue;

                isMaru = true;
                dfs(i, j);
                if (isMaru) ret++;
            }
        }

        System.out.println(ret);
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                list[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
