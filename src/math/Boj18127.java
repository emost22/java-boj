package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj18127 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static long A;
    private static int B;

    private static void func() {
        long ret = 1L;
        long cnt = 1L;
        while (B-- > 0) {
            cnt += (A - 2L);
            ret += cnt;
        }

        System.out.println(ret);
    }

    private static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Integer.parseInt(st.nextToken());
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
