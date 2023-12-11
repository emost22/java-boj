package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj14561 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuffer sb = new StringBuffer();
    private static long N;
    private static int B;

    private static void func() {
        String str = Long.toString(N, B).toUpperCase();
        int l = 0;
        int r = str.length() - 1;
        while (l < r) {
            if (str.charAt(l++) != str.charAt(r--)) {
                sb.append("0\n");
                return;
            }
        }
        sb.append("1\n");
    }

    private static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        B = Integer.parseInt(st.nextToken());
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int tc = Integer.parseInt(st.nextToken());

        while (tc-- > 0) {
            input();
            func();
        }

        System.out.print(sb);
    }
}
