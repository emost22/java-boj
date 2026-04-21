package dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj26169 {
    private static final int MAX = 5;
    private static final int direct[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private static int list[][];
    private static int N, M;

    private static boolean isOutOfRange(int x, int y) {
        return x < 0 || y < 0 || x >= MAX || y >= MAX;
    }


    private static boolean dfs(int x, int y, int cnt, int ate) {
        if (ate == 2) return true;
        if (cnt >= 3) return false;
        if (cnt == 2 && ate == 0) return false;

        for (int d = 0; d < 4; d++) {
            int nx = x + direct[d][0];
            int ny = y + direct[d][1];

            if (isOutOfRange(nx, ny)) continue;
            if (list[nx][ny] == -1) continue;

            int tmp = list[x][y];
            int nxt = ate + list[nx][ny];

            list[x][y] = -1;
            boolean flag = dfs(nx, ny, cnt + 1, nxt);
            if (flag) return true;
            list[x][y] = tmp;
        }

        return false;
    }

    private static void func() {
        if (dfs(N, M, 0, list[N][M] == 1 ? 1 : 0)) System.out.println(1);
        else System.out.println(0);
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        list = new int[MAX][MAX];
        for (int i = 0; i < MAX; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < MAX; j++) {
                list[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
