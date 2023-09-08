package dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Boj14284 {
    private static final int MAX = 1000000000;
    private static ArrayList<int[]> list[];
    private static int d[];
    private static int N, M, s, e;

    private static void dijkstra() {
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{s, 0});
        d[s] = 0;

        while (!q.isEmpty()) {
            int x = q.peek()[0];
            int dis = q.poll()[1];

            if (d[x] < dis) continue;

            for (int i = 0; i < list[x].size(); i++) {
                int next = list[x].get(i)[0];
                int nextDis = list[x].get(i)[1] + dis;

                if (d[next] > nextDis) {
                    d[next] = nextDis;
                    q.add(new int[]{next, nextDis});
                }
            }
        }
    }

    private static void func() {
        dijkstra();
        System.out.println(d[e]);
    }

    private static void init() {
        list = new ArrayList[N + 1];
        d = new int[N + 1];
        Arrays.fill(d, MAX);
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        init();

        int u, v, w;
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            list[u].add(new int[]{v, w});
            list[v].add(new int[]{u, w});
        }

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
