package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj2195 {
    private static String s, t;

    private static void func() {
        int ret = 0;
        int idx = 0;
        for (int i = idx + 1; i <= t.length(); i++) {
            if (s.contains(t.substring(idx, i))) {
                continue;
            }

            idx = i - 1;
            ret++;
        }

        System.out.println(ret + 1);
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        t = br.readLine();
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
