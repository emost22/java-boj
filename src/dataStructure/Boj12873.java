package dataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj12873 {
    private static Deque<Integer> q = new ArrayDeque<>();
    private static int N;

    private static void init() {
        for (int i = 1; i <= N; i++) {
            q.add(i);
        }
    }

    private static void func() {
        init();

        for (int i = 1; i < N; i++) {
            long next = ((long) i * i * i - 1) % (N - i + 1);

            while (next-- > 0) {
                q.add(q.poll());
            }
            q.poll();
        }

        System.out.println(q.poll());
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
