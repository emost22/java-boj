package queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj18115 {
    private final static int MAX = 1000001;
    private static int[] list = new int[MAX];
    private static int N;

    private static void func() {
        Deque<Integer> dq = new ArrayDeque<>();
        int num = 1;
        for (int i = N - 1; i >= 0; i--) {
            if (list[i] == 1) {
                dq.addLast(num++);
            } else if (list[i] == 2) {
                int tmp = dq.pollLast();
                dq.addLast(num++);
                dq.addLast(tmp);
            } else {
                dq.addFirst(num++);
            }
        }

        StringBuffer sb = new StringBuffer();
        while (!dq.isEmpty()) {
            sb.append(dq.pollLast() + " ");
        }

        System.out.println(sb.toString());
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
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
