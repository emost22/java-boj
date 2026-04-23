package bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj12887 {
    private static final int N = 2;
    private static final int direct[][] = {{1, 0}, {0, 1}, {-1, 0}};
    private static char list[][];
    private static int M;

    private static boolean isOutOfRange(int x, int y) {
        return x < 0 || y < 0 || x >= N || y >= M;
    }

    private static int bfs(int sx, int sy) {
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sx, sy});
        boolean visit[][] = new boolean[N][M];
        visit[sx][sy] = true;
        for (int t = 1; ; t++) {
            int qSize = q.size();
            while (qSize-- > 0) {
                int x = q.peek()[0];
                int y = q.poll()[1];

                if (y == M - 1) return t;

                for (int d = 0; d < 3; d++) {
                    int nx = x + direct[d][0];
                    int ny = y + direct[d][1];

                    if (isOutOfRange(nx, ny)) continue;
                    if (list[nx][ny] == '#') continue;
                    if (visit[nx][ny]) continue;

                    q.add(new int[]{nx, ny});
                    visit[nx][ny] = true;
                }
            }
        }
    }

    private static void func() {
        int write = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                write += (list[i][j] == '.' ? 1 : 0);
            }
        }

        int cnt = Integer.MAX_VALUE;
        if (list[0][0] == '.') cnt = Math.min(cnt, bfs(0, 0));
        if (list[1][0] == '.') cnt = Math.min(cnt, bfs(1, 0));
        System.out.println(write - cnt);
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        list = new char[N][M + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list[i] = st.nextToken().toCharArray();
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
