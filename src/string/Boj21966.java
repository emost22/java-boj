package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj21966 {
    private static StringBuffer sb = new StringBuffer();
    private static int N;

    private static void func() {
        if (sb.length() > 25) {
            if (sb.substring(11, sb.length() - 11).split("\\.").length > 1) {
                sb.replace(9, sb.length() - 10, "......");
            } else {
                sb.replace(11, sb.length() - 11, "...");
            }
        }

        System.out.println(sb);
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        sb.append(br.readLine());
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
