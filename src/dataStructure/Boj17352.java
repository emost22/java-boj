package dataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj17352 {
    private static int parent[] = new int[300001];
    private static int N;

    private static int find(int v) {
        if (parent[v] == v) return v;
        else return parent[v] = find(parent[v]);
    }

    private static void union(int u, int v) {
        u = find(u);
        v = find(v);

        if (parent[u] != parent[v]) {
            parent[u] = parent[v];
        }
    }

    private static void func() {
        int x = 1;
        for (int i = 2; i <= N; i++) {
            if (find(x) != find(i)) {
                System.out.println(x + " " + i);
                return;
            }
        }
    }

    private static void init() {
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        init();

        int u, v;
        for (int i = 0; i < N - 2; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            union(u, v);
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
