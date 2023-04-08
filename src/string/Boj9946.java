package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj9946 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int cnt[] = new int[26];
    private static String str, pat;
    private static StringBuffer sb = new StringBuffer();

    private static void func(int tc) {
        Arrays.fill(cnt, 0);
        for (int i = 0; i < str.length(); i++) {
            cnt[str.charAt(i) - 'a']++;
        }

        for (int i = 0; i < pat.length(); i++) {
            cnt[pat.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (cnt[i] != 0) {
                sb.append("Case ").append(tc).append(": different\n");
                return;
            }
        }

        sb.append("Case ").append(tc).append(": same\n");
    }

    private static void input() throws Exception {
        str = br.readLine();
        pat = br.readLine();
        if ("END".equals(str)) {
            System.out.print(sb.toString());
            System.exit(0);
        }
    }

    public static void main(String[] args) throws Exception {
        for (int tc = 1; ; tc++) {
            input();
            func(tc);
        }
    }
}
