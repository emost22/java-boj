package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj26040 {
    private static String str, list[];

    private static void func() {
        for (String pat : list) {
            str = str.replaceAll(pat, String.valueOf((char) (pat.charAt(0) + 32)));
        }

        System.out.println(str);
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        list = br.readLine().split(" ");
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
