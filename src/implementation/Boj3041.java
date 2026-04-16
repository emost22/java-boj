package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj3041 {
    private static final int MAX = 4;
    private static final int pos[][] = {{0, 0}, {0, 1}, {0, 2}, {0, 3}, {1, 0}, {1, 1}, {1, 2}, {1, 3}, {2, 0}, {2, 1}, {2, 2}, {2, 3}, {3, 0}, {3, 1}, {3, 2}};
    private static char list[][];

    private static int getAlphaIndex(char x) {
        if (x == '.') return -1;
        return x - 'A';
    }

    private static int getDistance(int sx, int sy, int ex, int ey) {
        return Math.abs(sx - ex) + Math.abs(sy - ey);
    }

    private static void func() {
        int ret = 0;
        for (int i = 0; i < MAX; i++) {
            for (int j = 0; j < MAX; j++) {
                int idx = getAlphaIndex(list[i][j]);
                if (idx == -1) continue;

                ret += getDistance(i, j, pos[idx][0], pos[idx][1]);
            }
        }

        System.out.println(ret);
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        list = new char[MAX][MAX];

        for (int i = 0; i < MAX; i++) {
            st = new StringTokenizer(br.readLine());
            list[i] = st.nextToken().toCharArray();
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
