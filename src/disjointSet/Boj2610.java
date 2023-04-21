package disjointSet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj2610 {
    private final static int MAX = 101;
    private static int parent[], list[][], dis[][], maxDis[], idx[];
    private static int N, M;

    private static int find(int v) {
        if (parent[v] == v) return v;
        else return parent[v] = find(parent[v]);
    }

    private static void union(int u, int v) {
        u = find(u);
        v = find(v);

        if (parent[u] == parent[v]) return;
        parent[v] = parent[u];
    }

    private static void floyd() {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (dis[i][j] > dis[i][k] + dis[k][j]) {
                        dis[i][j] = dis[i][k] + dis[k][j];
                    }
                }
            }
        }
    }

    private static void func() {
        floyd();
        for (int i = 0; i < M; i++) {
            union(list[i][0], list[i][1]);
        }

        int ret = 0;
        for (int i = 1; i <= N; i++) {
            int u = find(i);
            for (int j = 1; j <= N; j++) {
                if (i == j || dis[i][j] == MAX) continue;

                maxDis[i] = Math.max(maxDis[i], dis[i][j]);
            }

            if (idx[u] == 0) {
                idx[u] = i;
                ret++;
            } else {
                if (maxDis[i] < maxDis[idx[u]]) {
                    idx[u] = i;
                }
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (idx[i] == 0) continue;
            ans.add(idx[i]);
        }
        ans.sort((o1, o2) -> o1 - o2);

        StringBuffer sb = new StringBuffer();
        sb.append(ans.size()).append("\n");
        ans.forEach(res -> {
            sb.append(res).append("\n");
        });

        System.out.println(sb.toString());
    }

    private static void init() {
        parent = new int[N + 1];
        list = new int[M + 1][2];
        dis = new int[N + 1][N + 1];
        maxDis = new int[N + 1];
        idx = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            Arrays.fill(dis[i], MAX);
            dis[i][i] = 0;
        }
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());

        init();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            list[i][0] = Integer.parseInt(st.nextToken());
            list[i][1] = Integer.parseInt(st.nextToken());

            dis[list[i][0]][list[i][1]] = 1;
            dis[list[i][1]][list[i][0]] = 1;
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
