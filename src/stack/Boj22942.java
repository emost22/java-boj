package stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj22942 {
    private static PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> {
        if (o1[1] == o2[1]) {
            System.out.println("NO");
            System.exit(0);
        }

        return o1[1] - o2[1];
    });
    private static int N;

    private static void func() {
        Stack<Integer> s = new Stack<>();

        while (!q.isEmpty()) {
            int idx = q.poll()[0];

            if (s.isEmpty()) {
                s.add(idx);
                continue;
            }

            if (s.peek() == idx) s.pop();
            else s.push(idx);
        }

        if (s.isEmpty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        int x, r;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());

            q.add(new int[]{i, x + r});
            q.add(new int[]{i, x - r});
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
