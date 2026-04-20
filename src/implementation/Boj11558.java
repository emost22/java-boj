package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11558 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuffer sb = new StringBuffer();
    private static StringTokenizer st;
    private static int nx[];
    private static int N;

    private static void func() {
        boolean visit[] = new boolean[N + 1];
        int ret = 0;
        for (int i = 1; i != N; i = nx[i], ret++) {
            if (visit[i]) {
                sb.append("0\n");
                return;
            }

            visit[i] = true;
        }

        sb.append(ret).append("\n");
    }

    private static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        nx = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            nx[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void main(String[] args) throws Exception {
        int tc;
        st = new StringTokenizer(br.readLine());
        tc = Integer.parseInt(st.nextToken());
        while (tc-- > 0) {
            input();
            func();
        }

        System.out.print(sb.toString());
    }
}
