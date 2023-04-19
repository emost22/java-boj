package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj8949 {
    private static String str[];

    private static void func() {
        int len1 = str[0].length();
        int len2 = str[1].length();

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < Math.min(len1, len2); i++) {
            StringBuffer sum = new StringBuffer();
            sum.append(str[0].charAt(i) + str[1].charAt(i) - '0' - '0');
            sb.append(sum.reverse());
        }

        if (len1 > len2) {
            for (int i = len2; i < len1; i++) {
                sb.append(str[0].charAt(i));
            }
        } else {
            for (int i = len1; i < len2; i++) {
                sb.append(str[1].charAt(i));
            }
        }

        System.out.println(sb.reverse());
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        sb.append(br.readLine());
        sb.reverse();

        str = sb.toString().split(" ");
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
