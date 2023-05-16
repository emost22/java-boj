package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj25427 {
    private static char[] list;
    private static int N;

    private static void func() {
        long d = 0;
        long k = 0;
        long s = 0;
        long h = 0;
        for (int i = 0; i < N; i++) {
            if (list[i] == 'D') d++;
            else if (list[i] == 'K') k += d;
            else if (list[i] == 'S') s += k;
            else if (list[i] == 'H') h += s;
        }

        System.out.println(h);
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        list = st.nextToken().toCharArray();
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
