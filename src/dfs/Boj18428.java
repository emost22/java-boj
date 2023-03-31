package dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj18428 {
    private final static int MAX = 6;
    private static char list[][] = new char[MAX][MAX];
    private static ArrayList<int[]> tList = new ArrayList<>();
    private static int direct[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private static int N;

    private static boolean isHide() {
        for (int[] p : tList) {
            int x = p[0];
            int y = p[1];

            for (int d = 0; d < 4; d++) {
                int nx = x;
                int ny = y;

                while (true) {
                    nx += direct[d][0];
                    ny += direct[d][1];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= N) break;
                    if (list[nx][ny] == 'O') break;
                    if (list[nx][ny] == 'S') return false;
                }
            }
        }

        return true;
    }

    private static boolean dfs(int xy, int cnt) {
        if (cnt == 3) {
            return isHide();
        }

        int x = xy / N;
        int j = xy % N;
        for (int i = x; i < N; i++) {
            for (; j < N; j++) {
                if (list[i][j] != 'X') continue;

                list[i][j] = 'O';
                if (dfs(i * N + j + 1, cnt + 1)) return true;
                list[i][j] = 'X';
            }
            j = 0;
        }

        return false;
    }

    private static void func() {
        if (dfs(0, 0)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                list[i][j] = st.nextToken().charAt(0);
                if (list[i][j] == 'T') {
                    tList.add(new int[]{i, j});
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
