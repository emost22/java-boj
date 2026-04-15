package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1673 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuffer sb = new StringBuffer();

    private static int N, K;

    private static void func() {
        int ret = N;
        int cnt = N;
        while (cnt >= K) {
            int tmp = cnt / K;
            ret += tmp;
            cnt = cnt - tmp * K + tmp;
        }

        sb.append(ret).append("\n");
    }

    private static void input() throws Exception {
        String in = br.readLine();
        if (in == null) {
            System.out.print(sb.toString());
            System.exit(0);
        }

        st = new StringTokenizer(in);
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
    }

    public static void main(String[] args) throws Exception {
        while (true) {
            input();
            func();
        }
    }
}
