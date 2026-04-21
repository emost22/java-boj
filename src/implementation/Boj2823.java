package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2823 {
    private static final int direct[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private static char list[][];
    private static int N, M;

    private static boolean isOutOfRange(int x, int y) {
        return x < 0 || y < 0 || x >= N || y >= M;
    }

    private static void func() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (list[i][j] == 'X') continue;

                int cnt = 0;
                for (int d = 0; d < 4; d++) {
                    int nx = i + direct[d][0];
                    int ny = j + direct[d][1];
                    if (isOutOfRange(nx, ny)) continue;
                    if (list[nx][ny] == 'X') continue;

                    cnt++;
                }

                if (cnt == 1) {
                    System.out.println(1);
                    return;
                }
            }
        }
        System.out.println(0);
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new char[N + 1][M + 1];

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
