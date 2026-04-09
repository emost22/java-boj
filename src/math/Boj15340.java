package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj15340 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final int prices[][] = {{30, 40}, {35, 30}, {40, 20}};
    private static StringTokenizer st;
    private static StringBuffer sb = new StringBuffer();
    private static int c, d;

    private static void func() {
        int ret = Integer.MAX_VALUE;
        for (int[] p : prices) {
            ret = Math.min(ret, c * p[0] + d * p[1]);
        }

        sb.append(ret).append("\n");
    }

    private static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        if (c == 0 && d == 0) {
            System.out.print(sb.toString());
            System.exit(0);
        }
    }

    public static void main(String[] args) throws Exception {
        while (true) {
            input();
            func();
        }
    }
}
