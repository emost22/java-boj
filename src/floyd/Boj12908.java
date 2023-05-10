package floyd;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj12908 {
    private final static int INF = 2000000000;
    private final static int MAX = 8;
    private static int list[][] = new int[MAX][MAX];
    private static long dis[][] = new long[MAX][MAX];

    private static void func() {
        for (int i = 0; i < MAX; i++) {
            for (int j = i + 1; j < MAX; j++) {
                dis[i][j] = Math.abs(list[i][0] - list[j][0]) + Math.abs(list[i][1] - list[j][1]);
                dis[j][i] = dis[i][j];
            }
        }

        for (int i = 1; i < 7; i += 2) {
            dis[i][i + 1] = Math.min(dis[i][i + 1], 10);
            dis[i + 1][i] = dis[i][i + 1];
        }

        for (int k = 0; k < MAX; k++) {
            for (int i = 0; i < MAX; i++) {
                for (int j = 0; j < MAX; j++) {
                    dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
                }
            }
        }

        System.out.println(dis[0][7]);
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        list[0][0] = Integer.parseInt(st.nextToken());
        list[0][1] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        list[7][0] = Integer.parseInt(st.nextToken());
        list[7][1] = Integer.parseInt(st.nextToken());

        for (int i = 1; i < 7; i += 2) {
            st = new StringTokenizer(br.readLine());
            list[i][0] = Integer.parseInt(st.nextToken());
            list[i][1] = Integer.parseInt(st.nextToken());
            list[i + 1][0] = Integer.parseInt(st.nextToken());
            list[i + 1][1] = Integer.parseInt(st.nextToken());
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
