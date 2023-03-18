package dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj16437 {
    private static class Node {
        char type;
        long a;
        int v;

        Node(char type, long a, int v) {
            this.type = type;
            this.a = a;
            this.v = v;
        }
    }

    private static ArrayList<Node> graph[];
    private static Node list[];
    private static int N;

    private static long dfs(int v) {
        long ret = 0;
        if (list[v].type == 'S') {
            ret += list[v].a;
        } else {
            ret -= list[v].a;
        }

        for (Node node : graph[v]) {
            ret += dfs(node.v);
        }

        return ret >= 0 ? ret : 0;
    }

    private static void func() {
        System.out.println(dfs(1));
    }

    private static void init() {
        graph = new ArrayList[N + 1];
        list = new Node[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        list[1] = new Node('S', 0, 0);
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        init();

        char type;
        long a;
        int v;
        for (int i = 2; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            type = st.nextToken().charAt(0);
            a = Long.parseLong(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            list[i] = new Node(type, a, v);
            graph[v].add(new Node(type, a, i));
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
