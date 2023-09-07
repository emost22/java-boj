package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1081 {
    private static long cnt[] = new long[10];
    private static long left, right;

    private static void calc(long x, long mul) {
        while (x != 0) {
            cnt[(int) x % 10] += mul;
            x /= 10L;
        }
    }

    private static void solve(long l, long r, long mul) {
        while (l % 10 != 0 && l <= r) {
            calc(l, mul);
            l++;
        }

        while (r % 10 != 9 && l <= r) {
            calc(r, mul);
            r--;
        }

        if (l > r) return;

        long tmp = (r / 10L - l / 10L + 1) * mul;
        for (int i = 1; i < 10; i++) {
            cnt[i] += tmp;
        }

        solve(l / 10L, r / 10L, mul * 10L);
    }

    private static void func() {
        solve(left, right, 1L);

        long ret = 0;
        for (int i = 1; i < 10; i++) {
            ret += (cnt[i] * i);
        }

        System.out.println(ret);
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        left = Integer.parseInt(st.nextToken());
        right = Integer.parseInt(st.nextToken());
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
