package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2877 {
    private static final int MAX = 30;
    private static int N;

    private static void func() {
        String str = "";
        boolean flag = false;
        for (int i = MAX; i > 1; i--) {
            if ((1 << i) <= N) {
                if (!flag) flag = true;
                if ((1 << (i - 1)) <= N % (1 << i)) {
                    str += '7';
                } else {
                    str += '4';
                }
                N -= (1 << i);
            } else {
                if (!flag) continue;

                if ((1 << (i - 1)) <= N % (1 << i)) {
                    str += '7';
                } else {
                    str += '4';
                }
            }
        }

        if (N % 2 == 0) {
            str += '4';
        } else {
            str += '7';
        }

        System.out.println(str);
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()) + 1;
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
