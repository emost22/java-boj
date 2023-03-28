package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11179 {
    private static int N;

    private static void func() {
        StringBuffer sb = new StringBuffer();
        while (N > 0) {
            sb.append(N & 1);
            N >>= 1;
        }

        String str = sb.toString();
        int mul = 1;
        int ret = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            int x = str.charAt(i) - '0';

            ret += (x * mul);
            mul <<= 1;
        }

        System.out.println(ret);
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
