package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj23560 {
    private static int N;

    private static void func() {
        int ret = 2;
        while (--N > 0) {
            ret *= 3;
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
