package bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj25416 {
    private static final int MAX = 5;
    private static final int direct[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    private static int list[][];
    private static int sx, sy;

    private static boolean isOutOfRange(int x, int y) {
        return x < 0 || y < 0 || x >= MAX || y >= MAX;
    }

    private static void func() {
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sx, sy});
        boolean visit[][] = new boolean[MAX][MAX];
        visit[sx][sy] = true;

        for (int t = 1; !q.isEmpty(); t++) {
            int qSize = q.size();

            while (qSize-- > 0) {
                int x = q.peek()[0];
                int y = q.pop()[1];
                for (int d = 0; d < 4; d++) {
                    int nx = x + direct[d][0];
                    int ny = y + direct[d][1];

                    if (isOutOfRange(nx, ny)) continue;
                    if (visit[nx][ny]) continue;
                    if (list[nx][ny] == -1) continue;

                    if (list[nx][ny] == 1) {
                        System.out.println(t);
                        return;
                    }

                    q.add(new int[]{nx, ny});
                    visit[nx][ny] = true;
                }
            }
        }

        System.out.println(-1);
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
        sx = Integer.parseInt(st.nextToken());
        sy = Integer.parseInt(st.nextToken());
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
