package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj3460 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuffer sb = new StringBuffer();
    private static int N;

    private static void func() {
        for (int i = 0; N != 0; i++) {
            if ((N & 1) != 0) {
                sb.append(i).append(" ");
            }
            N >>= 1;
        }
        sb.append("\n");
    }

    private static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int tc = Integer.parseInt(st.nextToken());
        while (tc-- > 0) {
            input();
            func();
        }
        System.out.println(sb);
    }
}
