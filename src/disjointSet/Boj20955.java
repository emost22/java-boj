package disjointSet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj20955 {
    private static int parent[];
    private static int N, M;
    private static int cycle;

    private static int find(int v) {
        if (parent[v] == v) return v;
        else return parent[v] = find(parent[v]);
    }

    private static void union(int u, int v) {
        int a = find(u);
        int b = find(v);

        if (parent[a] != parent[b]) {
            parent[a] = b;
        }
    }

    private static void func() {
        boolean chk[] = new boolean[N + 1];
        int ret = 0;
        for (int i = 1; i <= N; i++) {
            int a = find(i);

            if (!chk[a]) {
                chk[a] = true;
                ret++;
            }
        }

        System.out.println(ret - 1 + cycle);
    }

    private static void init() {
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
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

            if (find(u) != find(v)) {
                union(u, v);
            } else {
                cycle++;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
