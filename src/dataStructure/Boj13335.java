package dataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj13335 {
    private final static int MAX = 1001;
    private static int list[] = new int[MAX];
    private static int N, W, L;
    private static Deque<int[]> q = new ArrayDeque<>();

    private static void func() {
        int t = 0;
        int idx = 0;
        int weight = 0;
        while (idx < N || !q.isEmpty()) {
            t++;

            while (!q.isEmpty() && q.peek()[0] + W <= t) {
                weight -= q.poll()[1];
            }

            if (idx < N && list[idx] + weight <= L) {
                q.add(new int[]{t, list[idx]});
                weight += list[idx++];
            }
        }

        System.out.println(t);
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
