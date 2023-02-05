package bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj6087 {
    private static class Pair {
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int x;
        int y;
    }

    private final static int MAX = 101;
    private static Deque<Pair> dq = new ArrayDeque<>();
    private static char list[][] = new char[MAX][MAX];
    private static int dis[][] = new int[MAX][MAX];
    private static int direct[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private static int N, M, ex, ey;

    private static boolean isInner(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }

    private static void bfs() {
        while (!dq.isEmpty()) {
            int x = dq.peek().x;
            int y = dq.poll().y;

            if (dis[ex][ey] != 0) {
                System.out.println(dis[ex][ey] - 1);
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nx = x;
                int ny = y;
                while (true) {
                    nx += direct[d][0];
                    ny += direct[d][1];

                    if (!isInner(nx, ny) || list[nx][ny] == '*') break;
                    if (dis[nx][ny] != 0) continue;

                    dis[nx][ny] = dis[x][y] + 1;
                    dq.add(new Pair(nx, ny));
                }
            }
        }
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list[i] = st.nextToken().toCharArray();
            for (int j = 0; j < M; j++) {
                if (list[i][j] == 'C') {
                    if (dq.isEmpty()) {
                        dq.add(new Pair(i, j));
                    } else {
                        ex = i;
                        ey = j;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        bfs();
    }
}