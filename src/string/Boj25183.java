package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj25183 {
    private final static int MAX = 100001;
    private static String str;
    private static int cnt[] = new int[MAX];
    private static int N;

    private static void func() {
        int ret = 0;
        cnt[0] = 1;
        for (int i = 1; i < str.length(); i++) {
            char x = str.charAt(i);
            char pre = str.charAt(i - 1);

            if (Math.abs(x - pre) == 1) {
                cnt[i] = cnt[i - 1] + 1;
            } else {
                cnt[i] = 1;
            }

            ret = Math.max(ret, cnt[i]);
        }

        System.out.println(ret >= 5 ? "YES" : "NO");
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
