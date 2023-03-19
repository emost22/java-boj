package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj27866 {
    private static String str;
    private static int idx;

    private static void func() {
        System.out.println(str.charAt(idx));
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        str = st.nextToken();

        st = new StringTokenizer(br.readLine());
        idx = Integer.parseInt(st.nextToken()) - 1;
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
