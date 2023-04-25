package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj15813 {
    private static String str;
    private static int N;

    private static int getInt(char x) {
        return x - 'A' + 1;
    }

    private static void func() {
        int ret = 0;
        for (int i = 0; i < N; i++) {
            ret += getInt(str.charAt(i));
        }

        System.out.println(ret);
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        str = br.readLine();
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
