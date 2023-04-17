package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj10813 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int list[];
    private static int N, M;

    private static void init() {
        list = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = i;
        }
    }

    private static void func() throws Exception {
        init();

        int x, y;
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            int tmp = list[x];
            list[x] = list[y];
            list[y] = tmp;
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= N; i++) {
            sb.append(list[i]).append(" ");
        }
        System.out.println(sb.toString());
    }

    private static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
