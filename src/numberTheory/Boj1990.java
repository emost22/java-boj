package numberTheory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1990 {
    private final static int MAX = 100000001;
    private static boolean isNotPrime[] = new boolean[MAX];
    private static int l, r;

    private static void init() {
        for (int i = 2; i < MAX; i++) {
            if (isNotPrime[i]) continue;

            for (int j = 2; i * j < MAX; j++) {
                isNotPrime[i * j] = true;
            }
        }
    }

    private static boolean isPalindrome(String str) {
        int len = str.length();
        int l = 0;
        int r = len - 1;
        while (l < r) {
            if (str.charAt(l++) != str.charAt(r--)) return false;
        }

        return true;
    }

    private static void func() {
        init();

        StringBuffer sb = new StringBuffer();
        for (int i = l; i <= r; i++) {
            if (isNotPrime[i]) continue;

            if (isPalindrome(String.valueOf(i))) {
                sb.append(i).append('\n');
            }
        }
        sb.append("-1\n");

        System.out.println(sb.toString());
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
