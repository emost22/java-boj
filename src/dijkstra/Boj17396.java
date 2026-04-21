package dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj17396 {
    private static class Node implements Comparable<Node> {
        int x;
        long t;

        public Node(int x, long t) {
            this.x = x;
            this.t = t;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.t, o.t);
        }
    }

    private static ArrayList<Node> list[];
    private static boolean vision[];
    private static long dis[];
    private static int N, M;

    private static void func() {
        Arrays.fill(dis, Long.MAX_VALUE);

        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(0, 0));
        dis[0] = 0;

        while (!q.isEmpty()) {
            int x = q.peek().x;
            long t = q.poll().t;

            if (dis[x] < t) continue;

            for (Node y : list[x]) {
                if (dis[y.x] > dis[x] + y.t) {
                    dis[y.x] = dis[x] + y.t;
                    q.add(new Node(y.x, dis[y.x]));
                }
            }
        }

        if (dis[N - 1] == Long.MAX_VALUE) System.out.println(-1);
        else System.out.println(dis[N - 1]);
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        vision = new boolean[N];
        dis = new long[N];
        list = new ArrayList[N];
        st = new StringTokenizer(br.readLine());
        int x;
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
            x = Integer.parseInt(st.nextToken());
            vision[i] = (x == 1);
        }

        int y;
        long t;
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());

            if (!vision[x] && !vision[y]) {
                list[x].add(new Node(y, t));
                list[y].add(new Node(x, t));
            } else if (!vision[x] && y == N - 1) {
                list[x].add(new Node(y, t));
            } else if (!vision[y] && x == N - 1) {
                list[y].add(new Node(x, t));
            }
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
