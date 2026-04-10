package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj31395 {
    private static int list[];
    private static int N;

    private static void func() {
        long ret = N;
        long cnt = 1L;
        for (int i = 1; i < N; i++) {
            if (list[i - 1] > list[i]) {
                ret += (cnt * (cnt - 1L) >> 1);
                cnt = 1L;
            } else {
                cnt++;
            }
        }
        ret += (cnt * (cnt - 1L) >> 1);

        System.out.println(ret);
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        list = new int[N];

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
