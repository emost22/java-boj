package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1871 {
    private static String[] strList;
    private static int N;

    private static void func() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < N; i++) {
            String str[] = strList[i].split("-");
            int l = (str[0].charAt(0) - 'A') * 26 * 26;
            l += ((str[0].charAt(1) - 'A') * 26);
            l += (str[0].charAt(2) - 'A');

            int r = Integer.parseInt(str[1]);

            if (Math.abs(r - l) <= 100) {
                sb.append("nice\n");
            } else {
                sb.append("not nice\n");
            }
        }

        System.out.println(sb);
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        strList = new String[N];
        for (int i = 0; i < N; i++) {
            strList[i] = br.readLine();
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
