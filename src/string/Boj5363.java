package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj5363 {
    private static String[][] str;
    private static int[] lens;
    private static int N;

    private static void func() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < lens[i]; j++) {
                sb.append(str[i][(j + 2) % lens[i]]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        str = new String[N][];
        lens = new int[N];

        for (int i = 0; i < N; i++) {
            str[i] = br.readLine().split(" ");
            lens[i] = str[i].length;
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
