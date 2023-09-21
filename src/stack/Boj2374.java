package stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj2374 {
    private static long list[];
    private static int N;

    private static void func() {
        Stack<Long> s = new Stack<>();
        s.push(list[1]);
        long maxValue = list[1];
        long ret = 0;
        for (int i = 2; i <= N; i++) {
            if (s.peek() == list[i]) continue;

            maxValue = Math.max(maxValue, list[i]);
            if (s.peek() > list[i]) {
                s.pop();
                s.push(list[i]);
            } else {
                ret += list[i] - s.pop();
                s.push(list[i]);
            }
        }

        ret += (maxValue - s.pop());
        System.out.println(ret);
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        list = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            list[i] = Long.parseLong(st.nextToken());
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
