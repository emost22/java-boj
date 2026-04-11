package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj15701 {
    private static int N;

    private static void func() {
        int ret = 0;
        for (int i = 1; i * i <= N; i++) {
            if (N % i != 0) continue;

            if (i * i == N) ret++;
            else ret += 2;
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
