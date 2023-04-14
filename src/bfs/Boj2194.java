package bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj2194 {
    private final static int MAX = 501;
    private static boolean map[][] = new boolean[MAX][MAX];
    private static boolean visit[][] = new boolean[MAX][MAX];
    private static int direct[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private static int N, M, A, B, K, sx, sy, ex, ey;

    private static boolean isPossible(int x, int y) {
        for (int i = 0; i < A; i++) {
            for (int j = 0; j < B; j++) {
                if (map[x + i][y + j]) return false;
            }
        }

        return true;
    }

    private static int bfs() {
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sx, sy});
        visit[sx][sy] = true;

        for (int t = 0; !q.isEmpty(); t++) {
            int qsize = q.size();
            while (qsize-- > 0) {
                int x = q.peek()[0];
                int y = q.poll()[1];

                if (x == ex && y == ey) return t;

                for (int d = 0; d < 4; d++) {
                    int nx = x + direct[d][0];
                    int ny = y + direct[d][1];

                    if (nx <= 0 || ny <= 0 || nx + A - 1 > N || ny + B - 1 > M) continue;
                    if (!isPossible(nx, ny) || visit[nx][ny]) continue;

                    q.add(new int[]{nx, ny});
                    visit[nx][ny] = true;
                }
            }
        }

        return -1;
    }

    private static void func() {
        System.out.println(bfs());
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int x, y;
        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            map[x][y] = true;
        }

        st = new StringTokenizer(br.readLine());
        sx = Integer.parseInt(st.nextToken());
        sy = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        ex = Integer.parseInt(st.nextToken());
        ey = Integer.parseInt(st.nextToken());
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
