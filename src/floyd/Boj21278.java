package floyd;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj21278 {
    private final static int MAX = 101;
    private static int dis[][] = new int[MAX][MAX];
    private static int N, M;

    private static void func() {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
                }
            }
        }

        int ret[] = new int[3];
        ret[2] = 10000;
        for (int x = 1; x < N; x++) {
            for (int y = x + 1; y <= N; y++) {
                int sum = 0;
                for (int i = 1; i <= N; i++) {
                    sum += Math.min(dis[x][i], dis[y][i]);
                }

                if (ret[2] > sum) {
                    ret[0] = x;
                    ret[1] = y;
                    ret[2] = sum;
                } else if (ret[2] == sum) {
                    if (ret[0] > x) {
                        ret[0] = x;
                        ret[1] = y;
                        ret[2] = sum;
                    } else if (ret[0] == x) {
                        if (ret[1] > y) {
                            ret[0] = x;
                            ret[1] = y;
                            ret[2] = sum;
                        }
                    }
                }
            }
        }

        System.out.println(ret[0] + " " + ret[1] + " " + (ret[2] << 1));
    }

    private static void init() {
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dis[i], 1000);
            dis[i][i] = 0;
        }
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        init();

        int u, v;
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            dis[u][v] = 1;
            dis[v][u] = 1;
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
