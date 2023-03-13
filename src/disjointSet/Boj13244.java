package disjointSet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj13244 {
    private final static int MAX = 1001;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int parent[] = new int[MAX];
    private static int N, M;
    private static boolean flag;
    private static StringBuffer sb = new StringBuffer();

    private static int find(int v) {
        if (parent[v] == v) return v;
        else return parent[v] = find(parent[v]);
    }

    private static void union(int u, int v) {
        int a = find(u);
        int b = find(v);

        if (parent[a] != parent[b]) parent[a] = b;
    }

    private static void func() {
        if (flag) {
            sb.append("tree\n");
        } else {
            sb.append("graph\n");
        }
    }

    private static void init() {
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        flag = true;
    }

    private static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        init();

        int u, v;
        int cnt = 0;
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            if (find(u) == find(v)) flag = false;
            else {
                union(u, v);
                cnt++;
            }
        }

        if (cnt != N - 1) {
            flag = false;
        }
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int tc = Integer.parseInt(st.nextToken());
        while (tc-- > 0) {
            input();
            func();
        }
        System.out.println(sb.toString());
    }
}
