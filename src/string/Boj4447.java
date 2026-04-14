package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj4447 {
    private static String list[];
    private static int N;

    private static String getAnswer(String str) {
        int g = 0;
        int b = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'g') g++;
            else if (str.charAt(i) == 'b') b++;
        }

        if (g > b) return "GOOD";
        if (b > g) return "A BADDY";
        return "NEUTRAL";
    }

    private static void func() {
        StringBuffer sb = new StringBuffer();

        for (String str : list) {
            sb.append(str).append(" is ").append(getAnswer(str.toLowerCase())).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        list = new String[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), "\n", true);
            list[i] = st.nextToken();
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
