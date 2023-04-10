package dataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj3078 {
    private static class Node {
        String name;
        int idx;

        public Node(String name, int idx) {
            this.name = name;
            this.idx = idx;
        }
    }

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static PriorityQueue<Node> q[] = new PriorityQueue[21];
    private static int N, M;

    private static void func() throws Exception {
        String str;
        int len;

        long ret = 0;
        for (int i = 0; i < N; i++) {
            str = br.readLine();
            len = str.length();

            while (!q[len].isEmpty() && i - q[len].peek().idx > M) {
                q[len].poll();
            }

            ret += q[len].size();
            q[len].add(new Node(str, i));
        }

        System.out.println(ret);
    }

    private static void init() {
        for (int i = 1; i <= 20; i++) {
            q[i] = new PriorityQueue<>((o1, o2) -> o1.idx - o2.idx);
        }
    }

    private static void input() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        init();
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
