package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj16888 {
    private static final int MAX = 1000001;
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuffer sb;
    private static boolean chk[];
    private static int N;

    private static void func() {
        if (chk[N]) sb.append("koosaga\n");
        else sb.append("cubelover\n");
    }

    private static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
    }

    private static void init() {
        sb = new StringBuffer();
        chk = new boolean[MAX];
        for (int i = 1; i * i < MAX; i++) {
            chk[i * i] = true;
        }

        for (int i = 2; i < MAX; i++) {
            if (chk[i]) continue;
            for (int j = 1; j * j <= i; j++) {
                if (chk[i - j * j]) continue;

                chk[i] = true;
                break;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        init();

        st = new StringTokenizer(br.readLine());
        int tc = Integer.parseInt(st.nextToken());
        while (tc-- > 0) {
            input();
            func();
        }

        System.out.print(sb.toString());
    }
}
